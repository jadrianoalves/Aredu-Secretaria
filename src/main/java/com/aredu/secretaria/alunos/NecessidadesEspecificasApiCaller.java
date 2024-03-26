package com.aredu.secretaria.alunos;

import com.aredu.secretaria.libs.ApiCaller;
import com.aredu.secretaria.turmas.Turma;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Component
public class NecessidadesEspecificasApiCaller extends ApiCaller<NecessidadeEspecifica> {
    public NecessidadesEspecificasApiCaller(WebClient.Builder webClientBuilder, @Value("${baseUrl}") String baseUrl, @Value("${alunoServer.port}") int port) {
        super(webClientBuilder, baseUrl + ":" + port + "/api/necessidades-especificas", "Necessidade", "Necessidades");
    }


    @Override
    public List<NecessidadeEspecifica> getAll() {
        List<NecessidadeEspecifica> necessidades = webClient.get()
                .uri(baseUrl)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<NecessidadeEspecifica>>() {})
                .blockOptional()
                .orElse(Collections.emptyList());

        return necessidades;
    }

    @Override
    protected Class<NecessidadeEspecifica> getResponseType() {
        return NecessidadeEspecifica.class;
    }
}
