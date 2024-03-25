package com.aredu.secretaria.turmas;

import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class TurmaApiCaller extends ApiCaller<Turma> {
    public TurmaApiCaller(WebClient.Builder webClientBuilder, @Value("${baseUrl}") String baseUrl, @Value("${alunoServer.port}") int port) {
        super(webClientBuilder, baseUrl + ":" + port + "/api/turmas", "Turma", "Turmas");
    }

    @Override
    protected Class<Turma> getResponseType() {
        return Turma.class;
    }
}
