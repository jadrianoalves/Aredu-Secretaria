package com.aredu.secretaria.dtos;

public class MatriculaContagem {

    private Long id;
    private Long alunoId;
    private Long TurmaId;
    private Integer anoLetivo;
    private String turno;


    public MatriculaContagem(Long id, Long alunoId, Long turmaId, Integer anoLetivo, String turno) {
        this.id = id;
        this.alunoId = alunoId;
        this.TurmaId = turmaId;
        this.anoLetivo = anoLetivo;
        this.turno = turno;
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

    public Long getTurmaId() {
        return TurmaId;
    }

    public void setTurmaId(Long turmaId) {
        TurmaId = turmaId;
    }

    public Integer getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(Integer anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
