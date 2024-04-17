package com.aredu.secretaria.documentos;

import com.aredu.secretaria.libs.ApiCaller;
import com.aredu.secretaria.matriculas.Matricula;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Component
public class DocumentoApiCaller extends ApiCaller<Documento> {

    public DocumentoApiCaller(WebClient.Builder webClientBuilder, @Value("${baseUrl}") String baseUrl, @Value("${documentosServer.port}") int port) {
        super(webClientBuilder, baseUrl + ":" + port + "/api/documentos", "Documento", "Documentos");
    }

    @Override
    protected Class<Documento> getResponseType() {
        return Documento.class;
    }

    public List<Documento> getAllByAlunoId(Long id) {
        return webClient.get()
                .uri(baseUrl+"/aluno/"+id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Documento>>() {})
                .blockOptional()
                .orElse(Collections.emptyList());
    }



}
