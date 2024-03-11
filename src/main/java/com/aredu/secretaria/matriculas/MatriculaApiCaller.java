package com.aredu.secretaria.matriculas;

import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.web.client.RestTemplate;

public class MatriculaApiCaller extends ApiCaller<Matricula> {

    public MatriculaApiCaller(RestTemplate restTemplate, String baseUrl) {
        super(restTemplate, baseUrl, "Matrícula", "Matriculas");
    }

    @Override
    protected Class<Matricula> getResponseType() {
        return Matricula.class;
    }
}
