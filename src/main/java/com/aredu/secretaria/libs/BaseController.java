package com.aredu.secretaria.libs;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aredu.secretaria.dtos.SearchRequest;

public abstract class BaseController<T> {

    protected final BaseServiceApi<T> service;
    protected final CrudMessage message;

    public BaseController(BaseServiceApi<T> service, String entidade, String entidadePlural) {
        this.service = service;
        this.message = new CrudMessage(entidade, entidadePlural);
    }



    @PostMapping
    public ResponseEntity<T> save(@RequestBody String dataJson) {
        try {
            T response = service.save(dataJson);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable Long id) {
        try {
            T response = service.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable Long id, @RequestBody String dataJson) {
        try {
            T response = service.update(id, dataJson);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            String response = service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(null);
        }
    }

    @PostMapping("/search")
    public ResponseEntity<List<T>> search(@RequestBody SearchRequest request) {
        try {
            List<T> result = service.search(request);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }



}
