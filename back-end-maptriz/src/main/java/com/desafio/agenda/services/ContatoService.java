package com.desafio.agenda.services;

import com.desafio.agenda.dto.ContatoDto;
import com.desafio.agenda.dto.ContatoDtoEdit;
import com.desafio.agenda.entities.Contato;
import com.desafio.agenda.entities.TipoPessoa;
import com.desafio.agenda.exceptions.error.PadraoIncorreto;
import com.desafio.agenda.repositories.ContatoRepository;
import com.desafio.agenda.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public List<ContatoDto> getAll() {
        List<ContatoDto> list = new ArrayList<>();
        repository.findAll().forEach(contato -> list.add(new ContatoDto(contato.getId(), contato.getNome(), contato.getCep(), contato.getTelefone(), contato.getTipoPessoa())));
        return list;
    }

    public ContatoDto getById(UUID id) {
        Optional<Contato> contato = repository.findById(id);
        if(contato.isPresent()){
            return new ContatoDto(contato.get().getId(), contato.get().getNome(), contato.get().getCep(), contato.get().getTelefone(), contato.get().getTipoPessoa());
        }
        throw new NoSuchElementException();
    }

    public void editContato(UUID id, ContatoDtoEdit contatoEdit) {

        Optional<Contato> contatoBD = repository.findById(id);
        if(contatoBD.isPresent()){
            if(Util.validatorTelefone(contatoEdit.getTelefone()) && Util.validatorCep(contatoEdit.getCep())){
                contatoBD.get().setNome(contatoEdit.getNome());
                contatoBD.get().setCep(contatoEdit.getCep());
                contatoBD.get().setTelefone(contatoEdit.getTelefone());
                repository.save(contatoBD.get());
            }else{
                throw new PadraoIncorreto("TELEFONE COM PADRÃO INCORRETO 'DDD XXXXXXXX' OU CEP");
            }

        }else{
            throw new NoSuchElementException();
        }



    }

    public void createContato(Contato contato) {
        if(contato.getTipoPessoa().ordinal() == 0){
            if (!Util.validatorCpf(contato.getNumeroDocumento())){
                throw new PadraoIncorreto("CPF COM PADRÃO INCORRETO");
            }
            if(!Util.validatorCep(contato.getCep())){
                throw new PadraoIncorreto("CEP COM PADRÃO INCORRETO");
            }
            if(!Util.validatorTelefone(contato.getTelefone())){
                throw new PadraoIncorreto("TELEFONE COM PADRÃO INCORRETO 'DDD XXXXXXXX'");

            }else{
                repository.save(contato);
            }
        }else{
            if(!Util.validatorCnpj(contato.getNumeroDocumento())){
                throw new PadraoIncorreto("CNPJ COM PADRÃO INCORRETO");
            }
            if(!Util.validatorCep(contato.getCep())){
                throw new PadraoIncorreto("CEP COM PADRÃO INCORRETO");
            }
            if(!Util.validatorTelefone(contato.getTelefone())){
                throw new PadraoIncorreto("TELEFONE COM PADRÃO INCORRETO 'DDD XXXXXXXX'");

            }else{
                repository.save(contato);
            }
        }


    }

    public void deleteContato(UUID id) {

        repository.deleteById(id);
    }





}

