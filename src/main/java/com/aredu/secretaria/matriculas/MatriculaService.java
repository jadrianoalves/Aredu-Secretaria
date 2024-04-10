package com.aredu.secretaria.matriculas;

import com.aredu.secretaria.dtos.MatriculaPorResponsavel;
import com.aredu.secretaria.libs.ApiCaller;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService extends BaseServiceApi<Matricula> {

    private final MatriculaApiCaller matriculaApiCaller;
    public MatriculaService(MatriculaApiCaller apiCaller) {
        super(apiCaller);
        this.matriculaApiCaller = apiCaller;
    }


    public List<Matricula> getAllByAlunoId(Long alunoId) {
        return matriculaApiCaller.getAllByAlunoId(alunoId);
    }

    public List<Matricula> getAllByEscolaId(Long id) {
        return matriculaApiCaller.getAllByEscolaId(id);
    }

    public List<Matricula> getAllByTurmaId(Long id) {
        return matriculaApiCaller.getAllByTurmaId(id);
    }

    public List<MatriculaPorResponsavel> getByEscolaIdAndResponsavelId(Long escolaId, Long responsavelId) {
        return matriculaApiCaller.getByEscolaIdAndResponsavelId(escolaId, responsavelId);
    }
}
