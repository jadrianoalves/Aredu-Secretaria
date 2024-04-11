package com.aredu.secretaria.dtos;

public class MatriculaPorResponsavel {

    private Long id;
    private Long alunoId;
    private String alunoNome;

    private String pastaAlunoId;

    public MatriculaPorResponsavel(Long id, Long alunoId, String alunoNome, String pastaAlunoId) {
        this.id = id;
        this.alunoId = alunoId;
        this.alunoNome = alunoNome;
        this.pastaAlunoId = pastaAlunoId;
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

    public String getPastaAlunoId() {
        return pastaAlunoId;
    }

    public void setPastaAlunoId(String pastaAlunoId) {
        this.pastaAlunoId = pastaAlunoId;
    }
}
