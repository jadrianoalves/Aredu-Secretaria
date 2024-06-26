package com.aredu.secretaria.turmas;

import com.aredu.secretaria.libs.ApiCaller;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService extends BaseServiceApi<Turma> {

    @Autowired
    private TurmaApiCaller turmaApiCaller;

    public TurmaService(TurmaApiCaller apiCaller) {
        super(apiCaller);
        this.turmaApiCaller = apiCaller;
    }


    public List<Turma> getAllByEscolaId(String id) {
        return turmaApiCaller.getAllByEscolaId(id);
    }
}
