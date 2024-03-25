package com.aredu.secretaria.alunos;

import java.time.LocalDate;

public class AlunoPCD {


    private Long id;
    private Aluno aluno;
    private String nivelSuporte;
    private boolean deficienciaFisica;
    private boolean deficienciaVisual;
    private boolean deficienciaIntelectual;
    private boolean deficienciaMental;
    private boolean deficienciaAuditiva;
    private boolean tea;
    private boolean superdotacaoAltasHabilidades;
    private String codigoCid;
    private LocalDate dataDiagnostico;
    private String descricaoDeficiencia;

    public AlunoPCD(Long id, Aluno aluno, String nivelSuporte, boolean deficienciaFisica, boolean deficienciaVisual, boolean deficienciaIntelectual, boolean deficienciaMental, boolean deficienciaAuditiva, boolean tea, boolean superdotacaoAltasHabilidades, String codigoCid, LocalDate dataDiagnostico, String descricaoDeficiencia) {
        this.id = id;
        this.aluno = aluno;
        this.nivelSuporte = nivelSuporte;
        this.deficienciaFisica = deficienciaFisica;
        this.deficienciaVisual = deficienciaVisual;
        this.deficienciaIntelectual = deficienciaIntelectual;
        this.deficienciaMental = deficienciaMental;
        this.deficienciaAuditiva = deficienciaAuditiva;
        this.tea = tea;
        this.superdotacaoAltasHabilidades = superdotacaoAltasHabilidades;
        this.codigoCid = codigoCid;
        this.dataDiagnostico = dataDiagnostico;
        this.descricaoDeficiencia = descricaoDeficiencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getNivelSuporte() {
        return nivelSuporte;
    }

    public void setNivelSuporte(String nivelSuporte) {
        this.nivelSuporte = nivelSuporte;
    }

    public boolean isDeficienciaFisica() {
        return deficienciaFisica;
    }

    public void setDeficienciaFisica(boolean deficienciaFisica) {
        this.deficienciaFisica = deficienciaFisica;
    }

    public boolean isDeficienciaVisual() {
        return deficienciaVisual;
    }

    public void setDeficienciaVisual(boolean deficienciaVisual) {
        this.deficienciaVisual = deficienciaVisual;
    }

    public boolean isDeficienciaIntelectual() {
        return deficienciaIntelectual;
    }

    public void setDeficienciaIntelectual(boolean deficienciaIntelectual) {
        this.deficienciaIntelectual = deficienciaIntelectual;
    }

    public boolean isDeficienciaMental() {
        return deficienciaMental;
    }

    public void setDeficienciaMental(boolean deficienciaMental) {
        this.deficienciaMental = deficienciaMental;
    }

    public boolean isDeficienciaAuditiva() {
        return deficienciaAuditiva;
    }

    public void setDeficienciaAuditiva(boolean deficienciaAuditiva) {
        this.deficienciaAuditiva = deficienciaAuditiva;
    }

    public boolean isTea() {
        return tea;
    }

    public void setTea(boolean tea) {
        this.tea = tea;
    }

    public boolean isSuperdotacaoAltasHabilidades() {
        return superdotacaoAltasHabilidades;
    }

    public void setSuperdotacaoAltasHabilidades(boolean superdotacaoAltasHabilidades) {
        this.superdotacaoAltasHabilidades = superdotacaoAltasHabilidades;
    }

    public String getCodigoCid() {
        return codigoCid;
    }

    public void setCodigoCid(String codigoCid) {
        this.codigoCid = codigoCid;
    }

    public LocalDate getDataDiagnostico() {
        return dataDiagnostico;
    }

    public void setDataDiagnostico(LocalDate dataDiagnostico) {
        this.dataDiagnostico = dataDiagnostico;
    }

    public String getDescricaoDeficiencia() {
        return descricaoDeficiencia;
    }

    public void setDescricaoDeficiencia(String descricaoDeficiencia) {
        this.descricaoDeficiencia = descricaoDeficiencia;
    }
}

