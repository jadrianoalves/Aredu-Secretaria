package com.aredu.secretaria.libs;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aredu.secretaria.dto.SearchRequest;

public abstract class BaseController<T> {

    protected final BaseServiceApi<T> service;
    protected final CrudMessage message;

    public BaseController(BaseServiceApi<T> service, String entidade, String entidadePlural) {
        this.service = service;
        this.message = new CrudMessage(entidade, entidadePlural);
    }



    @PostMapping
    public ResponseEntity<ApiResponse<T>> save(@RequestBody String dataJson) {
        try {
            T response = service.save(dataJson);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<T>(HttpStatus.CREATED, message.getSaveSuccessMessage(), response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<T>(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno ao processar a solicitação", null));
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<T>> getById(@PathVariable String id) {
        try {
            T response = service.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<T>(HttpStatus.OK, message.getGetByIdSuccessMessage(),response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<T>(HttpStatus.INTERNAL_SERVER_ERROR,"Erro interno ao processar a solicitação: " + e.getMessage(),null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<T>> update(@PathVariable String id, @RequestBody String dataJson) {
        try {
            T response = service.update(id, dataJson);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,message.getUpdateSuccessMessage(),response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, message.getUpdateErrorMessage(), null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable String id) {
        try {
            String response = service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<String>(HttpStatus.NO_CONTENT, message.getDeleteSuccessMessage(),response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<String>(HttpStatus.NO_CONTENT, message.getDeleteSuccessMessage(),null));
        }
    }

    @PostMapping("/search")
    public ResponseEntity<ApiResponse<List<T>>> search(@RequestBody SearchRequest request) {
        try {
            List<T> result = service.search(request);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<List<T>>(HttpStatus.OK, message.getListSuccessMessage(),result));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<List<T>>(HttpStatus.BAD_REQUEST, message.getListErrorMessage(),null));
        }
    }



}
