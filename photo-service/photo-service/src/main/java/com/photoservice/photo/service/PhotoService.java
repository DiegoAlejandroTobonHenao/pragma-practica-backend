package com.photoservice.photo.service;


import com.photoservice.photo.model.PhotoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PhotoService {
    List<PhotoDTO> findAll();
    List<PhotoDTO> listByIds(List<String> ids);
    PhotoDTO save(PhotoDTO fotoDTO);
    PhotoDTO findById(String id);
    PhotoDTO update(String id,PhotoDTO fotoDTO);
    void delete(String id);
}
