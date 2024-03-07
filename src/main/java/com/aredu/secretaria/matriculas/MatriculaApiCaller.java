package com.aredu.secretaria.matriculas;

import org.springframework.web.client.RestTemplate;

public class MatriculaApiCaller extends ApiCaller<Matricula> {

    public MatriculaApiCaller(RestTemplate restTemplate, String baseUrl) {
        super(restTemplate, baseUrl);
    }

    @Override
    protected Class<Matricula> getResponseType() {
        return Matricula.class;
    }
}
