package com.aredu.secretaria.responsavel;

import com.aredu.secretaria.libs.BaseController;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController extends BaseController<Responsavel> {
    @Autowired
    private ResponsavelService responsavelService;
    public ResponsavelController(ResponsavelService service) {
        super(service, "Responsável", "Responsáveis");
        this.responsavelService = service;
    }

    @GetMapping("/indice")
    public List<Responsavel> getIndex(){
        return responsavelService.getIndex();
    }

}
