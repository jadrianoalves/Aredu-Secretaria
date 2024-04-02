package com.aredu.secretaria.alunos;

import com.aredu.secretaria.libs.BaseController;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/")
    public ResponseEntity setNecessidadeEspecifica(@PathVariable String alunoId, @PathVariable String necessidadeId){
        return ResponseEntity.ok().body(necessidadesEspecificasService.setNecessidadeEspecifica(alunoId, necessidadeId));
    }

}
