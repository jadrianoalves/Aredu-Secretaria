package com.aredu.secretaria.alunos;

import com.aredu.secretaria.libs.ApiCaller;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NecessidadesEspecificasService extends BaseServiceApi<NecessidadeEspecifica> {

    private final NecessidadesEspecificasApiCaller necessidadesEspecificasApiCaller;
    public NecessidadesEspecificasService(NecessidadesEspecificasApiCaller apiCaller) {
        super(apiCaller);
        this.necessidadesEspecificasApiCaller = apiCaller;
    }

    public List<NecessidadeEspecifica> getAll(){
        return necessidadesEspecificasApiCaller.getAll();
    }

    public NecessidadeEspecifica setNecessidadeEspecifica(String alunoId, String necessidadeId){
        return necessidadesEspecificasApiCaller.setNecessidadeEspecifica(alunoId, necessidadeId);
    }

}
