package com.aredu.secretaria.alunos;

import com.aredu.secretaria.dtos.AlunoDTO;
import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Component
public class OcorrenciaApiCaller extends ApiCaller<Ocorrencia> {
    public OcorrenciaApiCaller(WebClient.Builder webClientBuilder, @Value("${baseUrl}") String baseUrl, @Value("${alunoServer.port}") int port) {
        super(webClientBuilder, baseUrl + ":" + port + "/api/alunos/ocorrencias",  "Ocorrencia", "Ocorrencias");
    }


    public List<Ocorrencia> getAllByAlunoId(Long id){
        List<Ocorrencia> ocorrencias =  webClient.get()
                .uri(baseUrl + "/" + id )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Ocorrencia>>() {})
                .blockOptional()
                .orElse(Collections.emptyList());
        return ocorrencias;
    }


    @Override
    protected Class<Ocorrencia> getResponseType() {
        return Ocorrencia.class;
    }
}
