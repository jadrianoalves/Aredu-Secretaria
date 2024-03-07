package com.aredu.secretaria.libs;

import com.aredu.secretaria.libs.ApiResponse;
import com.aredu.secretaria.dto.SearchRequest;
import com.aredu.secretaria.exceptions.ApiExternalException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public abstract class ApiCaller<T> {

    protected final RestTemplate restTemplate;
    protected final String baseUrl;

    protected final CrudMessage message;


    public ApiCaller(RestTemplate restTemplate, String baseUrl, String entidade, String entidadePlural) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.message = new CrudMessage(entidade, entidadePlural);

    }

    public T save(String dataJson) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(dataJson, headers);
        ResponseEntity<T> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.POST, requestEntity, getResponseType());

        return Optional.ofNullable(responseEntity.getBody())
                .orElseThrow(() -> new ApiExternalException(message.getSaveErrorMessage()));
    }

    public List<T> getAll() {
        ResponseEntity<List<T>> responseEntity = restTemplate.exchange(
                baseUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<T>>() {}
        );

        return Optional.ofNullable(responseEntity.getBody())
                .orElse(Collections.emptyList());
    }

    public T getById(String id) {
        return Optional.ofNullable(restTemplate.getForObject(baseUrl + "/" + id, getResponseType()))
                .orElseThrow(() -> new ApiExternalException(message.getGetByIdErrorMessage()));
    }

    public String update(String id, String dataJson) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(dataJson, headers);

        restTemplate.exchange(baseUrl + "/" + id, HttpMethod.PUT, requestEntity, String.class);

        return message.getUpdateSuccessMessage();
    }

    public String delete(String id) {
        restTemplate.delete(baseUrl + "/" + id);
        return message.getDeleteSuccessMessage();
    }

    public List<T> search(SearchRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<SearchRequest> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<List<T>> responseEntity = restTemplate.exchange(
                baseUrl + "/search",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<List<T>>() {}
        );

        return Optional.ofNullable(responseEntity.getBody())
                .orElseThrow(() -> new ApiExternalException(message.getListErrorMessage()));
    }

    protected abstract Class<T> getResponseType();
}