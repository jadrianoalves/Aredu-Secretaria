package com.aredu.secretaria.alunos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;


@Component
public class AlunoApiCaller extends ApiCaller<Aluno> {
    
	
	
    @Autowired
	public AlunoApiCaller(RestTemplateBuilder restTemplateBuilder, @Value("${baseUrl}") String baseUrl, @Value("${alunoServer.port}") int port) {
    
    	super(restTemplateBuilder.build(), baseUrl + ":" + port + "/api/alunos");
 	 
    }
        

    @Override
    protected Class<Aluno> getResponseType() {
        return Aluno.class;
    }
    
  

    
}
