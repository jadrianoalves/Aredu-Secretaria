package com.aredu.secretaria.libs;

import com.aredu.secretaria.dtos.SearchRequest;
import com.aredu.secretaria.exceptions.ApiExternalException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public abstract class ApiCaller<T> {

    protected final WebClient webClient;
    protected final String baseUrl;
    protected final CrudMessage message;

    public ApiCaller(WebClient.Builder webClientBuilder, String baseUrl, String entidade, String entidadePlural) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
        this.baseUrl = baseUrl;
        this.message = new CrudMessage(entidade, entidadePlural);
    }

    public T save(String dataJson) {
        return webClient.post()
                .uri(baseUrl)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(dataJson)
                .retrieve()
                .bodyToMono(getResponseType())
                .blockOptional()
                .orElseThrow(() -> new ApiExternalException(message.getSaveErrorMessage()));
    }

    public List<T> getAll() {
        return webClient.get()
                .uri(baseUrl)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, List<T>>>() {})
                .map(responseBody -> responseBody.get("data"))
                .blockOptional()
                .orElse(Collections.emptyList());
    }

    public T getById(String id) {
        return webClient.get()
                .uri(baseUrl + "/" + id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<T>() {})
                .blockOptional()
                .orElse(null);
    }

    public T update(String id, String dataJson) {
        return webClient.put()
                .uri(baseUrl + "/" + id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(dataJson)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<T>() {})
                .blockOptional()
                .orElseThrow(() -> new ApiExternalException("Erro ao editar entidade na API externa"));
    }

    public String delete(String id) {
        webClient.delete()
                .uri(baseUrl + "/" + id)
                .retrieve()
                .toBodilessEntity()
                .block();
        return message.getDeleteSuccessMessage();
    }

    public List<T> search(SearchRequest request) {
        return webClient.post()
                .uri(baseUrl + "/search")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<T>>() {})
                .blockOptional()
                .orElseThrow(() -> new ApiExternalException(message.getListErrorMessage()));
    }

    protected abstract Class<T> getResponseType();
}
