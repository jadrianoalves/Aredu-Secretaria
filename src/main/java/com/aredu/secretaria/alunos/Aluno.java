package com.aredu.secretaria.alunos;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class Aluno {
    private Long id;
    private String nome;
    private String genero;
    private LocalDate dataNascimento;
    private String filiacao1;
    private String filiacao1Profissao;
    private String filiacao2;
    private String filiacao2Profissao;
    private String naturalidade;
    private String naturalidadeUf;
    private String enderecoLogradouro;
    private String enderecoNumero;
    private String enderecoCep;
    private String enderecoBairro;
    private String enderecoCidade;
    private String enderecoCidadeUf;
    private String localResidencia;
    private String cpf;
    private String nacionalidade;
    private String obs;
    private String racaCor;
    private String pcd;
    private String pastaId;
    private String status;
    private LocalDate dataInscricao;

    public Aluno() {
    }

    public Aluno(String nome, String genero, LocalDate dataNascimento, String filiacao1, String filiacao1Profissao, String filiacao2, String filiacao2Profissao, String naturalidade, String naturalidadeUf, String enderecoLogradouro, String enderecoNumero, String enderecoCep, String enderecoBairro, String enderecoCidade, String enderecoCidadeUf, String localResidencia, String cpf, String nacionalidade, String obs, String racaCor, String pcd, String pastaId, String status, LocalDate dataInscricao) {
        this.nome = nome;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.filiacao1 = filiacao1;
        this.filiacao1Profissao = filiacao1Profissao;
        this.filiacao2 = filiacao2;
        this.filiacao2Profissao = filiacao2Profissao;
        this.naturalidade = naturalidade;
        this.naturalidadeUf = naturalidadeUf;
        this.enderecoLogradouro = enderecoLogradouro;
        this.enderecoNumero = enderecoNumero;
        this.enderecoCep = enderecoCep;
        this.enderecoBairro = enderecoBairro;
        this.enderecoCidade = enderecoCidade;
        this.enderecoCidadeUf = enderecoCidadeUf;
        this.localResidencia = localResidencia;
        this.cpf = cpf;
        this.nacionalidade = nacionalidade;
        this.obs = obs;
        this.racaCor = racaCor;
        this.pcd = pcd;
        this.pastaId = pastaId;
        this.status = status;
        this.dataInscricao = dataInscricao;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFiliacao1() {
        return filiacao1;
    }

    public void setFiliacao1(String filiacao1) {
        this.filiacao1 = filiacao1;
    }

    public String getFiliacao1Profissao() {
        return filiacao1Profissao;
    }

    public void setFiliacao1Profissao(String filiacao1Profissao) {
        this.filiacao1Profissao = filiacao1Profissao;
    }

    public String getFiliacao2() {
        return filiacao2;
    }

    public void setFiliacao2(String filiacao2) {
        this.filiacao2 = filiacao2;
    }

    public String getFiliacao2Profissao() {
        return filiacao2Profissao;
    }

    public void setFiliacao2Profissao(String filiacao2Profissao) {
        this.filiacao2Profissao = filiacao2Profissao;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNaturalidadeUf() {
        return naturalidadeUf;
    }

    public void setNaturalidadeUf(String naturalidadeUf) {
        this.naturalidadeUf = naturalidadeUf;
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

    public String getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
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

    public String getLocalResidencia() {
        return localResidencia;
    }

    public void setLocalResidencia(String localResidencia) {
        this.localResidencia = localResidencia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getRacaCor() {
        return racaCor;
    }

    public void setRacaCor(String racaCor) {
        this.racaCor = racaCor;
    }

    public String getPcd() {
        return pcd;
    }

    public void setPcd(String pcd) {
        this.pcd = pcd;
    }

    public String getPastaId() {
        return pastaId;
    }

    public void setPastaId(String pastaId) {
        this.pastaId = pastaId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(LocalDate dataInscricao) {
        this.dataInscricao = dataInscricao;
    }



}
