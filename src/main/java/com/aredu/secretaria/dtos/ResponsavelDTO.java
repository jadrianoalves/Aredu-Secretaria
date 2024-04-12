package com.aredu.secretaria.dtos;

public class ResponsavelDTO {

    private Long id;
    private String nome;
    private String cpf;

    private String contatos;

    public ResponsavelDTO(Long id, String nome, String cpf, String contatos) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getContatos() {
        return contatos;
    }

    public void setContatos(String contatos) {
        this.contatos = contatos;
    }
}
