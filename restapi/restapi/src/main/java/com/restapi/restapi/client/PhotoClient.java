package com.restapi.restapi.client;

import com.restapi.restapi.domain.Photo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name = "service-photo", path = "/photos",url = "localhost:8094", fallback = PhotoHystrixFallbackFactory.class)
public interface PhotoClient {
    @GetMapping
    public ResponseEntity<List<Photo>> listar();

    @GetMapping("/{id}")
    public ResponseEntity<Photo> buscar(@PathVariable String id);

    @PostMapping
    public ResponseEntity<Photo> registrar(@RequestBody Photo fotoDTO);

    @PostMapping("/ids")
    public ResponseEntity<List<Photo>> listarPorIds(@RequestBody List<String> ids);

    @PutMapping("/{id}")
    public ResponseEntity<Photo> actualizar(@PathVariable String id,@RequestBody Photo fotoDTO);

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String id);
}
