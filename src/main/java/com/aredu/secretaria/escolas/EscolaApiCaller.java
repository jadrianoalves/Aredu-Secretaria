package com.aredu.secretaria.escolas;

import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class EscolaApiCaller extends ApiCaller<Escola> {
    public EscolaApiCaller(WebClient.Builder webClientBuilder, @Value("${baseUrl}") String baseUrl, @Value("${escolaServer.port}") int port) {
        super(webClientBuilder, baseUrl + ":" + port + "/api/escolas", "Escola", "Escolas");
    }

    @Override
    protected Class<Escola> getResponseType() {
        return Escola.class;
    }
}
