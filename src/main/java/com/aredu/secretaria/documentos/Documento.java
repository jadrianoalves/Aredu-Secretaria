package com.aredu.secretaria.documentos;

import java.time.LocalDateTime;

public class Documento {
    private Long id;
    private Long alunoId;
    private String descricao;
    private String pastaId;
    private Double tamanho;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getPastaId() {
        return pastaId;
    }

    public void setPastaId(String pastaId) {
        this.pastaId = pastaId;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double serie) {
        this.tamanho = serie;
    }

}
