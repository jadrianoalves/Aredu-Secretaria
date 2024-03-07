package com.aredu.secretaria.alunos;

import com.aredu.secretaria.libs.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController extends BaseController<Aluno> {

    @Autowired
    public AlunoController(AlunoService alunoService) {
        super(alunoService);
    }
}
