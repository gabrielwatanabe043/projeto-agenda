package com.desafio.agenda.dto;

import com.desafio.agenda.entities.TipoPessoa;

import java.util.UUID;


public class ContatoDtoEdit {

    private UUID id;

    private String nome;

    private String cep;

    private String telefone;

    public ContatoDtoEdit() {
    }

    public ContatoDtoEdit(UUID id, String nome, String cep, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cep = cep;
        this.telefone = telefone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
