package com.aredu.secretaria.alunos;

import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

public class NecessidadesEspecificasApiCaller extends ApiCaller<NecessidadeEspecifica> {
    public NecessidadesEspecificasApiCaller(WebClient.Builder webClientBuilder, @Value("${baseUrl}") String baseUrl, @Value("${alunoServer.port}") int port) {
        super(webClientBuilder, baseUrl + ":" + port + "/api/necessidades-especificas", "Necessidade", "Necessidades");
    }



    @Override
    protected Class<NecessidadeEspecifica> getResponseType() {
        return NecessidadeEspecifica.class;
    }
}
