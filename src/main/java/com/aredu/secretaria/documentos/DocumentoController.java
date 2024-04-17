package com.aredu.secretaria.documentos;


import com.aredu.secretaria.libs.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/documentos")
public class DocumentoController extends BaseController<Documento> {

    @Autowired
    private final DocumentoService documentoService;
    public DocumentoController(DocumentoService service) {
        super(service, "Matrícula", "Matriculas");
        this.documentoService = service;
    }

    @GetMapping("/aluno/{id}")
    public ResponseEntity<List<Documento>> getAllByAlunoId(@PathVariable Long id){
        List<Documento> matriculas = documentoService.getAllByAlunoId(id);
        return ResponseEntity.ok(matriculas);
    }






}
