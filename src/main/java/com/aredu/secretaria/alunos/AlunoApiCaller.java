package com.aredu.secretaria.alunos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

import com.aredu.secretaria.ApiCaller;


@Component
public class AlunoApiCaller extends ApiCaller<Aluno> {
    
	
	
    @Autowired
	public AlunoApiCaller(RestTemplateBuilder restTemplateBuilder) {
    
    	super(restTemplateBuilder.build(), "http://localhost:8091/api/alunos");
 	 
    }
        

    @Override
    protected Class<Aluno> getResponseType() {
        return Aluno.class;
    }
    
  

    
}
