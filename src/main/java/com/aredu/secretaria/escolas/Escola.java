package com.aredu.secretaria.escolas;

import java.time.LocalDateTime;

public class Escola {

    private Long id;
    private String nome;

    private String enderecoLogradouro;

    private String enderecoNumero;

    private String enderecoBairro;

    private String enderecoCidade;

    private String enderecoCidadeUf;

    private String codigoInep;

    private String pastaId;


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

    public String getEnderecoLogradouro() {
        return enderecoLogradouro;
    }

    public void setEnderecoLogradouro(String enderecoLogradouro) {
        this.enderecoLogradouro = enderecoLogradouro;
    }

    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public String getEnderecoCidade() {
        return enderecoCidade;
    }

    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    public String getEnderecoCidadeUf() {
        return enderecoCidadeUf;
    }

    public void setEnderecoCidadeUf(String enderecoCidadeUf) {
        this.enderecoCidadeUf = enderecoCidadeUf;
    }

    public String getCodigoInep() {
        return codigoInep;
    }

    public void setCodigoInep(String codigoInep) {
        this.codigoInep = codigoInep;
    }

    public String getPastaId() {
        return pastaId;
    }

    public void setPastaId(String pastaId) {
        this.pastaId = pastaId;
    }
}

