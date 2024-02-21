package com.aredu.secretaria.alunos;


import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.aredu.secretaria.ApiResponse;
import com.aredu.secretaria.exceptions.ApiExternalException;

import org.springframework.boot.web.client.RestTemplateBuilder;

@Component
public class ApiService {

	private final RestTemplate restTemplate;
	private final String baseUrl;

	public ApiService(RestTemplateBuilder restTemplateBuilder,
			@Value("${python.microservice.base-url}") String baseUrl) {
		this.restTemplate = restTemplateBuilder.build();
		this.baseUrl = baseUrl;
	}
	
	

	public ApiResponse<Aluno> adicionarAluno(String alunoJson) {
	    try {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<String> request = new HttpEntity<>(alunoJson, headers);
	        Aluno response = restTemplate.postForObject(baseUrl + "/alunos", request, Aluno.class);
	        System.out.println("criou o aluno");
	        return new ApiResponse<>("success", "Aluno adicionado com sucesso", response);
	    } catch (HttpClientErrorException e) {
	        if (e.getStatusCode() == HttpStatus.NOT_FOUND || e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
	            // Lançar exceção personalizada
	            throw new ApiExternalException("Erro ao adicionar aluno na API externa", e);
	        }
	        if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
	            // Lançar exceção personalizada
	        	System.out.println(e);
	        	//throw new ApiExternalException("Erro ao adicionar aluno na API externa", e);
	        	return new ApiResponse<>("error","Aluno já existe:",null);
	        }
	        
	        // Tratamento genérico para outros erros HTTP
	        return new ApiResponse<>("error", "Erro ao adicionar aluno: " + e.getStatusCode() + " " + e.getStatusText(), null);
	    }
	}


	public String obterTodosAlunos() {
		return restTemplate.getForObject(baseUrl + "/alunos", String.class);
	}

	
	public ApiResponse<Aluno> obterAlunoPorId(String id) {
		
		try {
			
				Aluno aluno = restTemplate.getForObject(baseUrl + "/alunos/" + id, Aluno.class);
				return new ApiResponse<>("success", "Aluno encontrado com sucesso", aluno);
		
			} catch (HttpClientErrorException.NotFound e) {
			
				return new ApiResponse<>("error", "Aluno não encontrado", null);
		
			} catch (HttpClientErrorException e) {
			
				return new ApiResponse<>("error", "Erro ao obter aluno: " + e.getStatusCode() + " " + e.getStatusText(),
					null);
			}
	}

	public String atualizarAluno(String id, String alunoJson) {
		restTemplate.put(baseUrl + "/alunos/" + id, alunoJson);
		return "Aluno atualizado com sucesso";
	}

	public String excluirAluno(String id) {
		restTemplate.delete(baseUrl + "/alunos/" + id);
		return "Aluno excluído com sucesso";
	}

	public String buscarAlunosPorNome(String nome) {
		return restTemplate.getForObject(baseUrl + "/alunos/buscar?nome=" + nome, String.class);
	}

	public String atualizarParcialmenteAluno(String id, String alunoJson) {
		restTemplate.patchForObject(baseUrl + "/alunos/" + id, alunoJson, String.class);
		return "Aluno atualizado parcialmente com sucesso";
	}

	public String obterAlunosResumidos() {
		return restTemplate.getForObject(baseUrl + "/alunos/indice", String.class);
	}

	
}
