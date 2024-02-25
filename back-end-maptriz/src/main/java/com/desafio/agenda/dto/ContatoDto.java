package com.desafio.agenda.dto;

import com.desafio.agenda.entities.TipoPessoa;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


import java.util.UUID;


public class ContatoDto {
    private UUID id;

    private String nome;

    private String cep;

    private String telefone;

    private TipoPessoa tipoPessoa;

    public ContatoDto() {
    }

    public ContatoDto(UUID id, String nome, String cep, String telefone, TipoPessoa tipoPessoa) {
        this.id = id;
        this.nome = nome;
        this.cep = cep;
        this.telefone = telefone;
        this.tipoPessoa = tipoPessoa;
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

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
