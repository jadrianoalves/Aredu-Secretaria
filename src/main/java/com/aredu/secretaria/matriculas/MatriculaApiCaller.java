package com.aredu.secretaria.matriculas;

import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.web.reactive.function.client.WebClient;

public class MatriculaApiCaller extends ApiCaller<Matricula> {

    public MatriculaApiCaller(WebClient.Builder webClientBuilder, String baseUrl) {
        super(webClientBuilder, baseUrl, "Matrícula", "Matrículas");
    }

    @Override
    protected Class<Matricula> getResponseType() {
        return Matricula.class;
    }
}
