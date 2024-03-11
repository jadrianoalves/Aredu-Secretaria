package com.aredu.secretaria.alunos;

import com.aredu.secretaria.dtos.AlunoDTO;
import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Component
public class AlunoApiCaller extends ApiCaller<Aluno> {
    
	
	
    @Autowired
	public AlunoApiCaller(RestTemplateBuilder restTemplateBuilder, @Value("${baseUrl}") String baseUrl, @Value("${alunoServer.port}") int port) {
    
    	super(restTemplateBuilder.build(), baseUrl + ":" + port + "/api/alunos","Aluno","Alunos");
 	 
    }

    public List<AlunoDTO> getAllAlunos() {
        System.out.println("passou aqui");
        ResponseEntity<List<AlunoDTO>> responseEntity = restTemplate.exchange(
                baseUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AlunoDTO>>() {}
        );

        List<AlunoDTO> alunos = responseEntity.getBody();

        // Imprime os alunos no console
        System.out.println("Alunos recebidos:");
        alunos.forEach(System.out::println);

        return Optional.ofNullable(alunos)
                .orElse(Collections.emptyList());
    }

    @Override
    protected Class<Aluno> getResponseType() {
        return Aluno.class;
    }
    
  

    
}
