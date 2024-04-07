package com.aredu.secretaria.responsavel;

import com.aredu.secretaria.dtos.AlunoDTO;
import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Component
public class ResponsavelApiCaller extends ApiCaller<Responsavel> {
    public ResponsavelApiCaller(WebClient.Builder webClientBuilder, @Value("${baseUrl}") String baseUrl, @Value("${responsavelServer.port}") int port) {
        super(webClientBuilder, baseUrl + ":" + port + "/api/responsaveis", "Responsável", "Responsáveis");
    }

    public boolean verificarCPF(String cpf) {
        boolean responsavelExistente = webClient.get()
                .uri(baseUrl + "/consultar-cpf?cpf={cpf}", cpf)
                .retrieve()
                .bodyToMono(Boolean.class)
                .blockOptional()
                .orElse(false);
        return responsavelExistente;
    }

    public List<Responsavel> getIndex(){
        return webClient.get()
                .uri(baseUrl + "/indice")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Responsavel>>() {})
                .blockOptional()
                .orElse(Collections.emptyList());
    }

    @Override
    protected Class<Responsavel> getResponseType() {
        return Responsavel.class;
    }
}
