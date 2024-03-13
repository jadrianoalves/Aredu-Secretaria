package com.aredu.secretaria.responsavel;

import com.aredu.secretaria.libs.BaseController;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.beans.factory.annotation.Autowired;

public class ResponsavelController extends BaseController<Responsavel> {
    @Autowired
    private ResponsavelService responsavelService;
    public ResponsavelController(ResponsavelService service) {
        super(service, "Responsável", "Responsáveis");
        this.responsavelService = service;
    }
}
