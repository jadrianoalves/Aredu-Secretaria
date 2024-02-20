package com.aredu.secretaria.alunos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

@Component
public class ApiService {

    private final RestTemplate restTemplate;
    private final String baseUrl;

    public ApiService(RestTemplateBuilder restTemplateBuilder, @Value("${python.microservice.base-url}") String baseUrl) {
        this.restTemplate = restTemplateBuilder.build();
        this.baseUrl = baseUrl;
    }

    public String adicionarAluno(String alunoJson) {
        return restTemplate.postForObject(baseUrl + "/alunos", alunoJson, String.class);
    }

    public String obterTodosAlunos() {
        return restTemplate.getForObject(baseUrl + "/alunos", String.class);
    }

    public String obterAlunoPorId(String id) {
        return restTemplate.getForObject(baseUrl + "/alunos/" + id, String.class);
    }

    public String atualizarAluno(String id, String alunoJson) {
        restTemplate.put(baseUrl + "/alunos/" + id, alunoJson);
        return "Aluno atualizado com sucesso";
    }

    public String excluirAluno(String id) {
        restTemplate.delete(baseUrl + "/alunos/" + id);
        return "Aluno excluído com sucesso";
    }

    public String buscarAlunosPorNome(String nome) {
        return restTemplate.getForObject(baseUrl + "/alunos/buscar?nome=" + nome, String.class);
    }

    public String atualizarParcialmenteAluno(String id, String alunoJson) {
        restTemplate.patchForObject(baseUrl + "/alunos/" + id, alunoJson, String.class);
        return "Aluno atualizado parcialmente com sucesso";
    }

    public String obterAlunosResumidos() {
        return restTemplate.getForObject(baseUrl + "/alunos/indice", String.class);
    }
}


