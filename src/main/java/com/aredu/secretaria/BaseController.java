package com.aredu.secretaria;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<T> {

    protected BaseService<T> service;

    public BaseController(BaseService<T> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<T>> add(@RequestBody String dataJson) {
        ApiResponse<T> response = service.add(dataJson);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        List<T> entities = service.getAll();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable String id) {
        T response = service.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody String dataJson) {
        String response = service.update(id, dataJson);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        String response = service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
