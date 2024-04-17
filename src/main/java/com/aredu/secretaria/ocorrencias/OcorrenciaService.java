package com.aredu.secretaria.ocorrencias;


import com.aredu.secretaria.documentos.Documento;

import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcorrenciaService extends BaseServiceApi<Ocorrencia> {


    private final OcorrenciaApiCaller ocorrenciaApiCaller;
    public OcorrenciaService(OcorrenciaApiCaller apiCaller) {
        super(apiCaller);
        this.ocorrenciaApiCaller = apiCaller;
    }


    public List<Ocorrencia> getAllByAlunoId(Long id) {
        return ocorrenciaApiCaller.getAllByAlunoId(id);
    }

    public List<Ocorrencia> getAllByMatriculaId(Long id) {
        return ocorrenciaApiCaller.getAllByMatrciulaId(id);
    }

}
