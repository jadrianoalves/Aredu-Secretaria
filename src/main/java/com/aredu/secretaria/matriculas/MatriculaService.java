package com.aredu.secretaria.matriculas;

import com.aredu.secretaria.libs.ApiCaller;
import com.aredu.secretaria.libs.BaseServiceApi;

public class MatriculaService extends BaseServiceApi<Matricula> {

    private final MatriculaApiCaller matriculaApiCaller;
    public MatriculaService(MatriculaApiCaller apiCaller) {
        super(apiCaller);
        this.matriculaApiCaller = apiCaller;
    }

}
