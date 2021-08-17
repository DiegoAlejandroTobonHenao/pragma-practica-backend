package com.restapi.restapi.client;

import com.restapi.restapi.domain.Photo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Component
public class PhotoHystrixFallbackFactory implements PhotoClient{


    @Override
    public ResponseEntity<List<Photo>> listar() {
        return ResponseEntity.ok(new ArrayList<Photo>());
    }

    @Override
    public ResponseEntity<Photo> buscar(String id) {
        return ResponseEntity.ok(new Photo());
    }

    @Override
    public ResponseEntity<Photo> registrar(Photo fotoDTO) {
        return ResponseEntity.ok(new Photo());
    }

    @Override
    public ResponseEntity<List<Photo>> listarPorIds(List<String> ids) {
        List<Photo> fotos = new ArrayList<>();
        return ResponseEntity.ok(fotos);
    }

    @Override
    public ResponseEntity<Photo> actualizar(String id, Photo fotoDTO) {
        return ResponseEntity.ok(new Photo());
    }

    @Override
    public ResponseEntity<?> eliminar(String id) {
        return ResponseEntity.ok().build();
    }

}
