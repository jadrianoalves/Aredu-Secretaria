package com.aredu.secretaria.alunos;

import com.aredu.secretaria.dtos.AlunoDTO;
import com.aredu.secretaria.libs.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno-pcd")
public class AlunoPCDController extends BaseController<AlunoPCD> {

    @Autowired
    private final AlunoPCDService alunoService;

    @Autowired
    public AlunoPCDController(AlunoPCDService alunoService) {
        super(alunoService,"Aluno", "Alunos");
        this.alunoService = alunoService;
    }

    @PostMapping("/{alunoId}/necessidades/{necessidadeId}")
    public List<NecessidadeEspecifica> addNecessidadeAluno(@PathVariable Long alunoId, @PathVariable Long necessidadeId){
        return alunoService.addNecessidadeAluno(alunoId, necessidadeId);
    }

    @DeleteMapping("/{alunoId}/necessidades/{necessidadeId}")
    public ResponseEntity<String> deleteNecessidadeEspecifica(@PathVariable Long alunoId, @PathVariable Long necessidadeId) {
        try {
            String response = alunoService.deleteNecessidadeEspecifica(alunoId, necessidadeId);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }





}

