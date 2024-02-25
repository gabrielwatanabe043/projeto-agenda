package com.desafio.agenda.controller;

import com.desafio.agenda.dto.ContatoDto;
import com.desafio.agenda.dto.ContatoDtoEdit;
import com.desafio.agenda.entities.Contato;
import com.desafio.agenda.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contato")
public class ContatoController {


    @Autowired
    private ContatoService service;

    @GetMapping
    public ResponseEntity<List<ContatoDto>> gettAllContato(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoDto> getContatoById(@PathVariable UUID id){

        return ResponseEntity.ok().body(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> createContato(@RequestBody Contato contato){
        service.createContato(contato);
        final String URL = "https://run.mocky.io/v3/c9ec2ca3-a7f5-41d0-8550-b859508f4948";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(URL,String.class);

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editContato(@PathVariable UUID id, @RequestBody ContatoDtoEdit contatoEdit){
        service.editContato(id,contatoEdit);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Contato atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContato(@PathVariable UUID id){
        service.deleteContato(id);
        return ResponseEntity.ok().body("Contato deletado com sucesso");
    }

}
