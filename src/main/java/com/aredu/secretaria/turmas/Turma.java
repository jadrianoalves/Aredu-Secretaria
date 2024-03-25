package com.aredu.secretaria.turmas;



import java.time.LocalDateTime;


public class Turma {

    private Long id;
    private Long escolaId;
    private String nome;
    private Integer anoLetivo;
    private String turno;
    private String modalidade;
    private Integer serie;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Turma(Long id, Long escolaId, String nome, Integer anoLetivo, String turno, String modalidade, Integer serie) {
        this.id = id;
        this.escolaId = escolaId;
        this.nome = nome;
        this.anoLetivo = anoLetivo;
        this.turno = turno;
        this.modalidade = modalidade;
        this.serie = serie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEscolaId() {
        return escolaId;
    }

    public void setEscolaId(Long escolaId) {
        this.escolaId = escolaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }
}
