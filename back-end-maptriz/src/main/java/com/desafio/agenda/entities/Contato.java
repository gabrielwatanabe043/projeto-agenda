package com.desafio.agenda.entities;


import jakarta.persistence.*;



import java.util.UUID;

@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String numeroDocumento;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String telefone;


    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    public Contato() {
    }

    public Contato(UUID id, String nome, String numeroDocumento, String cep, String telefone, TipoPessoa tipoPessoa) {
        this.id = id;
        this.nome = nome;
        this.numeroDocumento = numeroDocumento;
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

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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
