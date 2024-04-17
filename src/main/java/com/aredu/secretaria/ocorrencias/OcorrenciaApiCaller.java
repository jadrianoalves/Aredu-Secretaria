package com.aredu.secretaria.ocorrencias;

import com.aredu.secretaria.documentos.Documento;
import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Component
public class OcorrenciaApiCaller extends ApiCaller<Ocorrencia> {

    public OcorrenciaApiCaller(WebClient.Builder webClientBuilder, @Value("${baseUrl}") String baseUrl, @Value("${ocorrenciasServer.port}") int port) {
        super(webClientBuilder, baseUrl + ":" + port + "/api/ocorrencias", "Ocorrencia", "Ocorrencias");
    }

    @Override
    protected Class<Ocorrencia> getResponseType() {
        return Ocorrencia.class;
    }

    public List<Ocorrencia> getAllByAlunoId(Long id) {
        return webClient.get()
                .uri(baseUrl+"/aluno/"+id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Ocorrencia>>() {})
                .blockOptional()
                .orElse(Collections.emptyList());
    }

    public List<Ocorrencia> getAllByMatrciulaId(Long id) {
        return webClient.get()
                .uri(baseUrl+"/matricula/"+id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Ocorrencia>>() {})
                .blockOptional()
                .orElse(Collections.emptyList());
    }
}
