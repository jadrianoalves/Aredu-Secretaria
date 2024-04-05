package com.aredu.secretaria.turmas;

import com.aredu.secretaria.dtos.AlunoDTO;
import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Component
public class TurmaApiCaller extends ApiCaller<Turma> {
    public TurmaApiCaller(WebClient.Builder webClientBuilder, @Value("${baseUrl}") String baseUrl, @Value("${turmaServer.port}") int port) {
        super(webClientBuilder, baseUrl + ":" + port + "/api/turmas", "Turma", "Turmas");
    }

    public List<Turma> getAll() {
        List<Turma> turmas = webClient.get()
                .uri(baseUrl)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Turma>>() {})
                .blockOptional()
                .orElse(Collections.emptyList());

        return turmas;
    }

    public List<Turma> getAllByEscolaId(String id) {
        List<Turma> turmas = webClient.get()
                .uri(baseUrl+"/escola/"+id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Turma>>() {})
                .blockOptional()
                .orElse(Collections.emptyList());

        return turmas;
    }

    public List<Turma> getAllByEscolaId() {
        List<Turma> turmas = webClient.get()
                .uri(baseUrl)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Turma>>() {})
                .blockOptional()
                .orElse(Collections.emptyList());

        return turmas;
    }

    @Override
    protected Class<Turma> getResponseType() {
        return Turma.class;
    }
}
