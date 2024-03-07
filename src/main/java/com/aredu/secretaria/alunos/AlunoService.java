package com.aredu.secretaria.alunos;
import org.springframework.stereotype.Service;


@Service
public class AlunoService extends BaseService<Aluno> {

	private final AlunoApiCaller alunoApiCaller;

	
	public AlunoService(AlunoApiCaller alunoApiCaller) {
	    super(alunoApiCaller);
	    this.alunoApiCaller = alunoApiCaller;
	}
}



