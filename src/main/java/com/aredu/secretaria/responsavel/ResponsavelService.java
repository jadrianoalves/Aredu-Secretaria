package com.aredu.secretaria.responsavel;

import com.aredu.secretaria.libs.AgeCalculatorService;
import com.aredu.secretaria.libs.ApiCaller;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsavelService extends BaseServiceApi<Responsavel> {

    @Autowired
    private ResponsavelApiCaller responsavelApiCaller;

    @Autowired
    private AgeCalculatorService ageCalculatorService;


    public ResponsavelService(ResponsavelApiCaller apiCaller) {
        super(apiCaller);
        this.responsavelApiCaller = apiCaller;
    }

    public List<Responsavel> getIndex(){
        return responsavelApiCaller.getIndex();
    }
}
