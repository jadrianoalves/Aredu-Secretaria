package com.aredu.secretaria.alunos;

import com.aredu.secretaria.libs.BaseController;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/necessidades-especificas")
public class NecessidadesEspecificasController extends BaseController<NecessidadeEspecifica> {


    private NecessidadesEspecificasService necessidadesEspecificasService;

    public NecessidadesEspecificasController(NecessidadesEspecificasService service) {
        super(service, "Necessidade", "Necessidades");
        this.necessidadesEspecificasService = service;
    }


    @GetMapping
    public ResponseEntity<List<NecessidadeEspecifica>> getAll(){
        return ResponseEntity.ok().body(necessidadesEspecificasService.getAll());
    }

}
