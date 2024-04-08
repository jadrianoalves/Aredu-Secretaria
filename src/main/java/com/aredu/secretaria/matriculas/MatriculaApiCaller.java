package com.aredu.secretaria.matriculas;

import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class MatriculaApiCaller extends ApiCaller<Matricula> {

    public MatriculaApiCaller(WebClient.Builder webClientBuilder, @Value("${baseUrl}") String baseUrl, @Value("${matriculaServer.port}") int port) {
        super(webClientBuilder, baseUrl + ":" + port + "/api/matriculas", "Matricula", "Matriculas");
    }

    public List<Matricula> getAllByAlunoId(Long alunoId) {
        return webClient.get()
                .uri(baseUrl+"/aluno/"+alunoId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Matricula>>() {})
                .blockOptional()
                .orElse(Collections.emptyList());
    }

    public List<Matricula> getAllByEscolaId(Long escolaId) {
        return webClient.get()
                .uri(baseUrl+"/escola/"+escolaId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Matricula>>() {})
                .blockOptional()
                .orElse(Collections.emptyList());
    }

    public List<Matricula> getAllByTurmaId(Long id) {
        return webClient.get()
                .uri(baseUrl+"/turma/"+id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Matricula>>() {})
                .blockOptional()
                .orElse(Collections.emptyList());
    }

    @Override
    protected Class<Matricula> getResponseType() {
        return Matricula.class;
    }
}
