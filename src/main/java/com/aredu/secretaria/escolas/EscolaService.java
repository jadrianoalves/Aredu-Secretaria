package com.aredu.secretaria.escolas;

import com.aredu.secretaria.libs.ApiCaller;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscolaService extends BaseServiceApi<Escola> {

    @Autowired
    private EscolaApiCaller escolaApiCaller;

    public EscolaService(EscolaApiCaller apiCaller) {
        super(apiCaller);
        this.escolaApiCaller = apiCaller;
    }

}
