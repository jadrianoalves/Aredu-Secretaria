package com.aredu.secretaria.escolas;

import com.aredu.secretaria.dtos.SearchRequest;
import com.aredu.secretaria.libs.BaseController;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/escolas")
public class EscolaController extends BaseController<Escola> {

    @Autowired
    private EscolaService escolaService;

    public EscolaController(EscolaService service) {
        super(service, "Escola", "Escolas");
        this.escolaService = service;
    }

    @GetMapping
    public ResponseEntity<List<Escola>> getAll() {
        return ResponseEntity.ok(escolaService.getAll());
    }


}
