package com.aredu.secretaria;

import java.util.List;

import org.springframework.web.client.HttpClientErrorException;
import com.aredu.secretaria.exceptions.ApiExternalException;

public abstract class BaseService<T> {

    protected ApiCaller<T> apiCaller;

    public BaseService(ApiCaller<T> apiCaller) {
        this.apiCaller = apiCaller;
    }

    public ApiResponse<T> add(String dataJson) {
        try {
            return apiCaller.add(dataJson);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().is4xxClientError()) {
                throw new ApiExternalException("Erro ao adicionar entidade na API externa", e);
            }
            return new ApiResponse<>("error", "Erro ao adicionar entidade: " + e.getStatusCode() + " " + e.getStatusText(), null);
        }
    }

    public List<T> getAll() {
        return apiCaller.getAll();
    }

    public T getById(String id) {
        try {
            return apiCaller.getById(id);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().is4xxClientError()) {
                throw new ApiExternalException("Erro ao obter entidade por ID na API externa", e);
            }
            // Se necessário, você pode lidar com outros tipos de exceções aqui
            throw e;
        }
    }

    public String update(String id, String dataJson) {
        try {
            return apiCaller.update(id, dataJson);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().is4xxClientError()) {
                throw new ApiExternalException("Erro ao atualizar entidade na API externa", e);
            }
            return "Erro ao atualizar entidade: " + e.getStatusCode() + " " + e.getStatusText();
        }
    }

    public String delete(String id) {
        try {
            return apiCaller.delete(id);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().is4xxClientError()) {
                throw new ApiExternalException("Erro ao excluir entidade na API externa", e);
            }
            return "Erro ao excluir entidade: " + e.getStatusCode() + " " + e.getStatusText();
        }
    }
}

