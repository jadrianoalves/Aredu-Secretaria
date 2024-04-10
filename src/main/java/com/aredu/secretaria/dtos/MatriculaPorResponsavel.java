package com.aredu.secretaria.dtos;

public class MatriculaPorResponsavel {

    private Long id;
    private Long alunoId;
    private String alunoNome;

    public MatriculaPorResponsavel(Long id, Long alunoId, String alunoNome) {
        this.id = id;
        this.alunoId = alunoId;
        this.alunoNome = alunoNome;
    }

    public MatriculaPorResponsavel() {
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

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }
}
