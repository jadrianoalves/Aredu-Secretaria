package com.aredu.secretaria.alunos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final ApiService apiService;

    @Autowired
    public AlunoService(ApiService apiService) {
        this.apiService = apiService;
    }

    public String adicionarAluno(String alunoJson) {
        return apiService.adicionarAluno(alunoJson);
    }

    public String obterTodosAlunos() {
        return apiService.obterTodosAlunos();
    }

    public String obterAlunoPorId(String id) {
        return apiService.obterAlunoPorId(id);
    }

    public String atualizarAluno(String id, String alunoJson) {
        return apiService.atualizarAluno(id, alunoJson);
    }

    public String excluirAluno(String id) {
        return apiService.excluirAluno(id);
    }

    public String buscarAlunosPorNome(String nome) {
        return apiService.buscarAlunosPorNome(nome);
    }

    public String atualizarParcialmenteAluno(String id, String alunoJson) {
        return apiService.atualizarParcialmenteAluno(id, alunoJson);
    }

    public String obterAlunosResumidos() {
        return apiService.obterAlunosResumidos();
    }
}

