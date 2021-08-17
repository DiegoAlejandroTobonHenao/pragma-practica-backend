package com.photoservice.photo.controller;

import com.photoservice.photo.document.Photo;

import com.photoservice.photo.model.PhotoDTO;
import com.photoservice.photo.service.PhotoService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/photos")
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST , RequestMethod.DELETE, RequestMethod.PUT})
public class PhotoController {
    @Autowired
    private PhotoService fotoService;

    @GetMapping
    public ResponseEntity<List<PhotoDTO>> listar(){
        List<PhotoDTO> fotos = fotoService.findAll();
        return ResponseEntity.ok(fotos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotoDTO> buscar(@PathVariable String id){
        PhotoDTO fotoDTO = fotoService.findById(id);
        return ResponseEntity.ok(fotoDTO);
    }

    @PostMapping
    public ResponseEntity<PhotoDTO> registrar(@RequestBody PhotoDTO fotoDTO){
        PhotoDTO fotoDto = fotoService.save(fotoDTO);
        return ResponseEntity.ok(fotoDto);
    }

    @PostMapping("/ids")
    public ResponseEntity<List<PhotoDTO>> listarPorIds(@RequestBody (required = true) List<String> ids){
        List<PhotoDTO> fotos = fotoService.listByIds(ids);
        return ResponseEntity.ok(fotos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhotoDTO> actualizar(@PathVariable String id, @RequestBody PhotoDTO fotoDTO){
        PhotoDTO fotoDto = fotoService.update(id,fotoDTO);
        return ResponseEntity.ok(fotoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String id){
        fotoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
