package com.desafio.agenda.exceptions.error;

import org.apache.coyote.Response;
import org.hibernate.PropertyValueException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorMessage> contatoNotFound(NoSuchElementException exception){
        ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, "Contato não encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<ErrorMessage> CampoNulo(PropertyValueException exception){
        ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST, "Campo " + exception.getPropertyName().toUpperCase() + " não pode ser nulo");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(PadraoIncorreto.class)
    public ResponseEntity<ErrorMessage> CpfComPadraoIncorreto(PadraoIncorreto exception){
        ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> CpfouCnpjDuplicado (ConstraintViolationException exception){

        ErrorMessage error = new ErrorMessage(HttpStatus.CONFLICT, "Já existe documento cadastrado");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}
