package com.aredu.secretaria.alunos;

import com.aredu.secretaria.libs.BaseController;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos/ocorrencias")
public class OcorrenciaController extends BaseController<Ocorrencia> {

    @Autowired
    private OcorrenciasService service;
    public OcorrenciaController(OcorrenciasService service) {
        super(service, "Ocorrencia", "Ocorrencias");
    }

    @GetMapping("/aluno/{id}")
    public ResponseEntity<List<Ocorrencia>> getAllByAlunoId (@PathVariable Long id){
        List<Ocorrencia> response = Optional.ofNullable(service.getByAlunoId(id)).orElse(Collections.emptyList());
        return ResponseEntity.ok(response);
    }

}
