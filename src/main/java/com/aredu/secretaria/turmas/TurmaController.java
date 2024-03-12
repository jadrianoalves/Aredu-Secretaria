package com.aredu.secretaria.turmas;

import com.aredu.secretaria.libs.BaseController;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.beans.factory.annotation.Autowired;

public class TurmaController extends BaseController<Turma> {

    @Autowired
    private TurmaService turmaService;
    public TurmaController(TurmaService service) {
        super(service, "Turma", "Turmas");
        this.turmaService = service;
    }
}
