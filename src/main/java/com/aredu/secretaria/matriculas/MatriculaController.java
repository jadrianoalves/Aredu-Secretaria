package com.aredu.secretaria.matriculas;

import com.aredu.secretaria.libs.BaseController;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.beans.factory.annotation.Autowired;

public class MatriculaController extends BaseController<Matricula> {

    @Autowired
    private final MatriculaService matriculaService;
    public MatriculaController(MatriculaService service) {
        super(service, "Matrícula", "Matriculas");
        this.matriculaService = service;
    }
}
