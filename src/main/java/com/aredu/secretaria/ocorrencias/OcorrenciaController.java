package com.aredu.secretaria.ocorrencias;

import com.aredu.secretaria.libs.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController extends BaseController<Ocorrencia> {

    @Autowired
    private final OcorrenciaService ocorrenciaService;
    public OcorrenciaController(OcorrenciaService service) {
        super(service, "Ocorrencia", "Ocorrencias");
        this.ocorrenciaService = service;
    }

    @GetMapping("/aluno/{id}")
    public ResponseEntity<List<Ocorrencia>> getAllByAlunoId(@PathVariable Long id){
        List<Ocorrencia> matriculas = ocorrenciaService.getAllByAlunoId(id);
        return ResponseEntity.ok(matriculas);
    }

    @GetMapping("/matricula/{id}")
    public ResponseEntity<List<Ocorrencia>> getAllByMatriculaId(@PathVariable Long id){
        List<Ocorrencia> matriculas = ocorrenciaService.getAllByMatriculaId(id);
        return ResponseEntity.ok(matriculas);
    }



   


}
