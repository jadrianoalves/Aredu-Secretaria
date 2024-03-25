package com.aredu.secretaria.alunos;

import com.aredu.secretaria.libs.BaseController;
import com.aredu.secretaria.libs.BaseServiceApi;

public class NecessidadesEspecificasController extends BaseController<NecessidadeEspecifica> {


    private NecessidadesEspecificasService necessidadesEspecificasService;

    public NecessidadesEspecificasController(NecessidadesEspecificasService service) {
        super(service, "Necessidade", "Necessidades");
        this.necessidadesEspecificasService = service;
    }
}
