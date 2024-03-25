package com.aredu.secretaria.alunos;

import com.aredu.secretaria.dtos.AlunoDTO;
import com.aredu.secretaria.libs.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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





}

