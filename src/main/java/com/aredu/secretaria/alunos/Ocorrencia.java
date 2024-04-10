package com.aredu.secretaria.alunos;


import java.time.LocalDateTime;


public class Ocorrencia {

    private Long id;

    private Long alunoId;
    private String tipo;

    private String descricao;

    private LocalDateTime dataDaOcorrencia;

    private String user;

    public Ocorrencia(Long id, Long alunoId, String tipo, String descricao, LocalDateTime dataDaOcorrencia, String user) {
        this.id = id;
        this.alunoId = alunoId;
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataDaOcorrencia = dataDaOcorrencia;
        this.user = user;
    }

    public Ocorrencia() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataDaOcorrencia() {
        return dataDaOcorrencia;
    }

    public void setDataDaOcorrencia(LocalDateTime dataDaOcorrencia) {
        this.dataDaOcorrencia = dataDaOcorrencia;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


}
