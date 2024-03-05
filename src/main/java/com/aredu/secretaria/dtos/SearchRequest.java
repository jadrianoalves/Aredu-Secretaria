package com.aredu.secretaria.dto;

import java.util.List;

public class SearchRequest {
    private List<String> campos;
    private List<String> filtro;

    public List<String> getCampos() {
        return campos;
    }

    public void setCampos(List<String> campos) {
        this.campos = campos;
    }

    public List<String> getFiltro() {
        return filtro;
    }

    public void setFiltro(List<String> filtro) {
        this.filtro = filtro;
    }
}


