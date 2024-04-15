package com.aredu.secretaria.matriculas;

import com.aredu.secretaria.dtos.MatriculaContagem;
import com.aredu.secretaria.dtos.MatriculaPorResponsavel;
import com.aredu.secretaria.libs.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController extends BaseController<Matricula> {

    @Autowired
    private final MatriculaService matriculaService;
    public MatriculaController(MatriculaService service) {
        super(service, "Matrícula", "Matriculas");
        this.matriculaService = service;
    }

    @GetMapping("/aluno/{id}")
    public ResponseEntity<List<Matricula>> getAllByAlunoId(@PathVariable Long id){
        List<Matricula> matriculas = matriculaService.getAllByAlunoId(id);
        return ResponseEntity.ok(matriculas);
    }

    @GetMapping("/escola/{id}")
    public ResponseEntity<List<Matricula>> getAllByEscolaId(@PathVariable Long id){
        List<Matricula> matriculas = matriculaService.getAllByEscolaId(id);
        return ResponseEntity.ok(matriculas);
    }

    @GetMapping("/resumo/{id}")
    public ResponseEntity<List<MatriculaContagem>> getResumo(@PathVariable Long id){
        List<MatriculaContagem> matriculas = matriculaService.getResumo(id);
        return ResponseEntity.ok(matriculas);
    }

    @GetMapping("/turma/{id}")
    public ResponseEntity<List<Matricula>> getAllByTurmaId(@PathVariable Long id){
        List<Matricula> matriculas = matriculaService.getAllByTurmaId(id);
        return ResponseEntity.ok(matriculas);
    }

    @GetMapping("/responsaveis/{escolaId}/{responsavelId}")
    public ResponseEntity<List<MatriculaPorResponsavel>> getAllByTurmaId(@PathVariable Long escolaId, @PathVariable Long responsavelId){
        List<MatriculaPorResponsavel> matriculas = matriculaService.getByEscolaIdAndResponsavelId(escolaId, responsavelId);
        return ResponseEntity.ok(matriculas);
    }


}
