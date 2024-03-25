package com.aredu.secretaria.turmas;

import com.aredu.secretaria.libs.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController extends BaseController<Turma> {

    @Autowired
    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        super(turmaService, "Turma", "Turmas");
        this.turmaService = turmaService;
    }

    @GetMapping
    public ResponseEntity<List<Turma>> getAll(){
    System.out.println("passou por aqui");
        return ResponseEntity.ok().body(turmaService.getAll());
    }

}
