package com.aredu.secretaria.responsavel;

import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.web.reactive.function.client.WebClient;

public class ResponsavelApiCaller extends ApiCaller<Responsavel> {
    public ResponsavelApiCaller(WebClient.Builder webClientBuilder, String baseUrl) {
        super(webClientBuilder, baseUrl, "Responsável", "Responsáveis");
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

    @Override
    protected Class<Responsavel> getResponseType() {
        return Responsavel.class;
    }
}
