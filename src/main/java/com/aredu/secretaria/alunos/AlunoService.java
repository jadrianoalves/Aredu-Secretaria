package com.aredu.secretaria.alunos;
import com.aredu.secretaria.dtos.AlunoDTO;
import com.aredu.secretaria.exceptions.ApiExternalException;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AlunoService extends BaseServiceApi<Aluno> {

	@Autowired
	private final AlunoApiCaller alunoApiCaller;

	
	public AlunoService(AlunoApiCaller alunoApiCaller) {
        super(alunoApiCaller);
        this.alunoApiCaller = alunoApiCaller;
	}


	public List<AlunoDTO> getAllAlunos() {
		return Optional.ofNullable(alunoApiCaller.getAllAlunos())
				.orElseThrow(() -> new ApiExternalException("Erro ao obter todas as entidades da API externa"));
	}

}



