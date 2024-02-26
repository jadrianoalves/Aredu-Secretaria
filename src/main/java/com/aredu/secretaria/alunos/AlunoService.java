package com.aredu.secretaria.alunos;
import org.springframework.stereotype.Service;

import com.aredu.secretaria.ApiCaller;
import com.aredu.secretaria.BaseService;


@Service
public class AlunoService extends BaseService<Aluno> {

	private final AlunoApiCaller alunoApiCaller;

	
	public AlunoService(AlunoApiCaller alunoApiCaller) {
	    super(alunoApiCaller);
	    this.alunoApiCaller = alunoApiCaller;
	}
}



