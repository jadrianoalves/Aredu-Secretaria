package com.aredu.secretaria.alunos;

import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;



@Component
public class AlunoPCDApiCaller extends ApiCaller<AlunoPCD> {

    @Autowired
    public AlunoPCDApiCaller(WebClient.Builder webClientBuilder, @Value("${baseUrl}") String baseUrl, @Value("${alunoServer.port}") int port) {
        super(webClientBuilder, baseUrl + ":" + port + "/api/aluno-pcd", "AlunoPCD", "AlunosPCD");
    }








    @Override
    protected Class<AlunoPCD> getResponseType() {
        return AlunoPCD.class;
    }
}
