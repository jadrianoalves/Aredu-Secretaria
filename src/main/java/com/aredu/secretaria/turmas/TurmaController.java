package com.aredu.secretaria.turmas;

import com.aredu.secretaria.libs.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turmas")
public class TurmaController extends BaseController<Turma> {

    @Autowired
    private final TurmaService turmaService;
    public TurmaController(TurmaService service) {
        super(service, "Turma", "Turmas");
        this.turmaService = service;
    }
}
