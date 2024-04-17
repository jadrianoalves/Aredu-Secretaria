package com.aredu.secretaria.ocorrencias;

import java.time.LocalDate;

public class Ocorrencia {

    private Long id;

    private String descricao;

    private Long matriculaId;

    private Long alunoId;

    private String tipo;

    private LocalDate dataDaOcorrencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(Long matriculaId) {
        this.matriculaId = matriculaId;
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

    public LocalDate getDataDaOcorrencia() {
        return dataDaOcorrencia;
    }

    public void setDataDaOcorrencia(LocalDate dataDaOcorrencia) {
        this.dataDaOcorrencia = dataDaOcorrencia;
    }
}
