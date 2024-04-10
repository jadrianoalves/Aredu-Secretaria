package com.aredu.secretaria.alunos;

import com.aredu.secretaria.libs.ApiCaller;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcorrenciasService extends BaseServiceApi<Ocorrencia> {

    private OcorrenciaApiCaller apiCaller;
    public OcorrenciasService(OcorrenciaApiCaller apiCaller) {
        super(apiCaller);
    }

    public List<Ocorrencia> getByAlunoId(Long id){
        return apiCaller.getAllByAlunoId(id);
    }


}
