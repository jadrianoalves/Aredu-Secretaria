package com.aredu.secretaria.alunos;

import com.aredu.secretaria.libs.ApiCaller;
import com.aredu.secretaria.libs.BaseServiceApi;

public class NecessidadesEspecificasService extends BaseServiceApi<NecessidadeEspecifica> {

    private final NecessidadesEspecificasApiCaller necessidadesEspecificasApiCaller;
    public NecessidadesEspecificasService(NecessidadesEspecificasApiCaller apiCaller) {
        super(apiCaller);
        this.necessidadesEspecificasApiCaller = apiCaller;
    }
}
