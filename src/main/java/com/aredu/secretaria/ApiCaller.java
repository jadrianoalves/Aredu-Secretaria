package com.aredu.secretaria;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.lang.reflect.ParameterizedType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aredu.secretaria.dto.SearchRequest;
import com.aredu.secretaria.exceptions.ApiExternalException;


@Service
public abstract class ApiCaller<T> {

    protected final RestTemplate restTemplate;
    protected final String baseUrl;
    


    public ApiCaller(RestTemplate restTemplate, String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        
    }

    public ApiResponse<T> add(String dataJson) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> requestEntity = new HttpEntity<>(dataJson, headers);
            ResponseEntity<T> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.POST, requestEntity, getResponseType());

            T response = responseEntity.getBody();

            return new ApiResponse<>("success", "Entidade adicionada com sucesso", response);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().is4xxClientError()) {
                throw new ApiExternalException("Erro ao adicionar entidade na API externa", e);
            }
            return new ApiResponse<>("error", "Erro ao adicionar entidade: " + e.getStatusCode() + " " + e.getStatusText(), null);
        }
    }

    public List<T> getAll() {
        ResponseEntity<List<T>> responseEntity = restTemplate.exchange(
        		baseUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<T>>() {}
        );
        return responseEntity.getBody();
    }

    public T getById(String id) {
        try {
            return restTemplate.getForObject(baseUrl + "/" + id, getResponseType());
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().is4xxClientError()) {
                throw new ApiExternalException("Erro ao obter entidade por ID na API externa", e);
            }
            throw e; // Lança a exceção original se não for um erro 4xx
        }
    }

    public String update(String id, String dataJson) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(dataJson, headers);

        try {
            restTemplate.exchange(baseUrl + "/" + id, HttpMethod.PUT, requestEntity, String.class);
            return "Entidade atualizada com sucesso";
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().is4xxClientError()) {
                throw new ApiExternalException("Erro ao atualizar entidade na API externa", e);
            }
            return "Erro ao atualizar entidade: " + e.getStatusCode() + " " + e.getStatusText();
        }
    }

    public String delete(String id) {
        try {
            restTemplate.delete(baseUrl + "/" + id);
            return "Entidade excluída com sucesso";
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().is4xxClientError()) {
                throw new ApiExternalException("Erro ao excluir entidade na API externa", e);
            }
            return "Erro ao excluir entidade: " + e.getStatusCode() + " " + e.getStatusText();
        }
    }
    
    
    public List<T> search(SearchRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<SearchRequest> requestEntity = new HttpEntity<>(request, headers);

        try {
            ResponseEntity<List<T>> responseEntity = restTemplate.exchange(
                baseUrl + "/search",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<List<T>>() {}
            );

            return responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().is4xxClientError()) {
                throw new ApiExternalException("Erro ao buscar alunos na API externa", e);
            }
            throw e;
        }
    }

    protected abstract Class<T> getResponseType();
}
