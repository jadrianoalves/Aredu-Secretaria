package com.aredu.secretaria.alunos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final ApiService apiService;

    @Autowired
    public AlunoController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping
    public String adicionarAluno(@RequestBody String alunoJson) {
        return apiService.adicionarAluno(alunoJson);
    }

    @GetMapping
    public String obterTodosAlunos() {
        return apiService.obterTodosAlunos();
    }

    @GetMapping("/{id}")
    public String obterAlunoPorId(@PathVariable String id) {
        return apiService.obterAlunoPorId(id);
    }

    @PutMapping("/{id}")
    public String atualizarAluno(@PathVariable String id, @RequestBody String alunoJson) {
        return apiService.atualizarAluno(id, alunoJson);
    }

    @DeleteMapping("/{id}")
    public String excluirAluno(@PathVariable String id) {
        return apiService.excluirAluno(id);
    }

    @GetMapping("/buscar")
    public String buscarAlunosPorNome(@RequestParam String nome) {
        return apiService.buscarAlunosPorNome(nome);
    }

    @PatchMapping("/{id}")
    public String atualizarParcialmenteAluno(@PathVariable String id, @RequestBody String alunoJson) {
        return apiService.atualizarParcialmenteAluno(id, alunoJson);
    }

    @GetMapping("/indice")
    public String obterAlunosResumidos() {
        return apiService.obterAlunosResumidos();
    }
}
