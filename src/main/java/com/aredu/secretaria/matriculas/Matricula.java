package com.aredu.secretaria.matriculas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class Matricula {
    private Long id;
    private String anoLetivo;
    private Long alunoId;
    private String alunoNome;
    private LocalDate alunoDataNasc;
    private Long turmaId;
    private Long escolaId;
    private String turmaNome;
    private String turmaTurno;
    private Integer responsavelId;
    private String responsavelParentesco;
    private String responsavelContato;
    private Date dataMatricula;
    private String escolaOrigem;
    private String fardamento;
    private String transporte;
    private String tipo;
    private String observacoes;
    private String status;
    private String pastaAlunoId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(String anoLetivo) {
        this.anoLetivo = anoLetivo;
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

    public LocalDate getAlunoDataNasc() {
        return alunoDataNasc;
    }

    public void setAlunoDataNasc(LocalDate alunoDataNasc) {
        this.alunoDataNasc = alunoDataNasc;
    }

    public Long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }

    public Long getEscolaId() {
        return escolaId;
    }

    public void setEscolaId(Long escolaId) {
        this.escolaId = escolaId;
    }

    public String getTurmaNome() {
        return turmaNome;
    }

    public void setTurmaNome(String turmaNome) {
        this.turmaNome = turmaNome;
    }

    public String getTurmaTurno() {
        return turmaTurno;
    }

    public void setTurmaTurno(String turmaTurno) {
        this.turmaTurno = turmaTurno;
    }

    public Integer getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(Integer responsavelId) {
        this.responsavelId = responsavelId;
    }

    public String getResponsavelParentesco() {
        return responsavelParentesco;
    }

    public void setResponsavelParentesco(String responsavelParentesco) {
        this.responsavelParentesco = responsavelParentesco;
    }

    public String getResponsavelContato() {
        return responsavelContato;
    }

    public void setResponsavelContato(String responsavelContato) {
        this.responsavelContato = responsavelContato;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getEscolaOrigem() {
        return escolaOrigem;
    }

    public void setEscolaOrigem(String escolaOrigem) {
        this.escolaOrigem = escolaOrigem;
    }

    public String getFardamento() {
        return fardamento;
    }

    public void setFardamento(String fardamento) {
        this.fardamento = fardamento;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPastaAlunoId() {
        return pastaAlunoId;
    }

    public void setPastaAlunoId(String pastaAlunoId) {
        this.pastaAlunoId = pastaAlunoId;
    }
}
