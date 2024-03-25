package com.aredu.secretaria.alunos;
import com.aredu.secretaria.dtos.AlunoDTO;
import com.aredu.secretaria.exceptions.ApiExternalException;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AlunoPCDService extends BaseServiceApi<AlunoPCD> {

	@Autowired
	private final AlunoPCDApiCaller alunoApiCaller;


	public AlunoPCDService(AlunoPCDApiCaller alunoApiCaller) {
        super(alunoApiCaller);
        this.alunoApiCaller = alunoApiCaller;
	}

	public boolean addNecessidadeAluno(Long alunoPCDId, Long necessidadeId){
		return alunoApiCaller.addNecessidadeEspecificaAAluno(alunoPCDId, necessidadeId);
	}





}



