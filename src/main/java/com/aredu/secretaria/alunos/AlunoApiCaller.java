package com.aredu.secretaria.alunos;

import com.aredu.secretaria.dtos.AlunoDTO;
import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class AlunoApiCaller extends ApiCaller<Aluno> {

    @Autowired
    public AlunoApiCaller(WebClient.Builder webClientBuilder, @Value("${baseUrl}") String baseUrl, @Value("${alunoServer.port}") int port) {
        super(webClientBuilder, baseUrl + ":" + port + "/api/alunos", "Aluno", "Alunos");
    }

    public List<AlunoDTO> getAllAlunos() {

        List<AlunoDTO> alunos = webClient.get()
                .uri(baseUrl)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<AlunoDTO>>() {})
                .blockOptional()
                .orElse(Collections.emptyList());

        return alunos;
    }

    public boolean verificarCPF(String cpf) {
        boolean alunoExistente = webClient.get()
                .uri(baseUrl + "/consultar-cpf?cpf={cpf}", cpf)
                .retrieve()
                .bodyToMono(Boolean.class)
                .blockOptional()
                .orElse(false);
        return alunoExistente;
    }




    @Override
    protected Class<Aluno> getResponseType() {
        return Aluno.class;
    }
}
