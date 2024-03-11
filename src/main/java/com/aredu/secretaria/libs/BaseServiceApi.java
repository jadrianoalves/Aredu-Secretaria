package com.aredu.secretaria.libs;

import com.aredu.secretaria.libs.ApiCaller;
import com.aredu.secretaria.dto.SearchRequest;
import com.aredu.secretaria.exceptions.ApiExternalException;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceApi<T> {

    protected ApiCaller<T> apiCaller;

    public BaseServiceApi(ApiCaller<T> apiCaller) {
        this.apiCaller = apiCaller;
    }

    public T save(String dataJson) {
        return Optional.ofNullable(apiCaller.save(dataJson))
                .orElseThrow(() -> new ApiExternalException("Erro ao adicionar entidade na API externa"));
    }

    public List<T> getAll() {
        return Optional.ofNullable(apiCaller.getAll())
                .orElseThrow(() -> new ApiExternalException("Erro ao obter todas as entidades da API externa"));
    }

    public T getById(String id) {
        return Optional.ofNullable(apiCaller.getById(id))
                .orElseThrow(() -> new ApiExternalException("Erro ao obter entidade por ID na API externa"));
    }

    public T update(String id, String dataJson) {
        return Optional.ofNullable(apiCaller.update(id, dataJson))
                .orElseThrow(() -> new ApiExternalException("Erro ao editar entidade na API externa"));
    }

    public String delete(String id) {
        return Optional.ofNullable(apiCaller.delete(id))
                .orElse("Erro ao excluir entidade na API externa");
    }

    public List<T> search(SearchRequest request) {
        return Optional.ofNullable(apiCaller.search(request))
                .orElseThrow(() -> new ApiExternalException("Erro ao buscar alunos na API externa"));
    }
}
