package com.aredu.secretaria.turmas;

import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.web.reactive.function.client.WebClient;

public class TurmaApiCaller extends ApiCaller<Turma> {
    public TurmaApiCaller(WebClient.Builder webClientBuilder, String baseUrl) {
        super(webClientBuilder, baseUrl, "Turma", "Turmas");
    }

    @Override
    protected Class<Turma> getResponseType() {
        return Turma.class;
    }
}
