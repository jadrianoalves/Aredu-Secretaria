package com.aredu.secretaria.alunos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aredu.secretaria.ApiResponse;
import com.aredu.secretaria.exceptions.ApiExternalException;


@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final ApiService apiService;

    @Autowired
    public AlunoController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Aluno>> adicionarAluno(@RequestBody String alunoJson) {
        try {
            ApiResponse<Aluno> response = apiService.adicionarAluno(alunoJson);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApiExternalException e) {
            ApiResponse<Aluno> errorResponse = new ApiResponse<>("error", e.getMessage(), null);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public String obterTodosAlunos() {
        return apiService.obterTodosAlunos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Aluno>> obterAlunoPorId(@PathVariable String id) {
        ApiResponse<Aluno> response = apiService.obterAlunoPorId(id);
        if (response.getStatus().equals("success")) {
            return ResponseEntity.ok(response);
        } else if (response.getMessage().equals("Aluno não encontrado")) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
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
