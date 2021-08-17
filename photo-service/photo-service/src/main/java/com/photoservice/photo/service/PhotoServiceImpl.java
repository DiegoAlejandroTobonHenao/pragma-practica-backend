package com.photoservice.photo.service;

import com.photoservice.photo.document.Photo;
import com.photoservice.photo.exception.PhotoException;
import com.photoservice.photo.model.PhotoDTO;
import com.photoservice.photo.repository.PhotoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhotoServiceImpl implements PhotoService{
    @Autowired
    private PhotoRepository fotoDao;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PhotoDTO> findAll() {
        List<PhotoDTO> fotoDTOS = null;
        List<Photo> fotos = fotoDao.findAll();
        if(fotos.isEmpty()){
            throw new PhotoException(HttpStatus.NO_CONTENT, "No se encuentran fotos en la bd");
        }
        fotoDTOS = fotos.stream().map(foto -> {
            return modelMapper.map(foto, PhotoDTO.class);
        }).collect(Collectors.toList());

        return fotoDTOS;
    }

    @Override
    public List<PhotoDTO> listByIds(List<String> ids) {
        List<PhotoDTO> fotosDTO = null;
        List<Photo> fotos = fotoDao.findByIdIn(ids);
        if(fotos.isEmpty()){
            throw new PhotoException(HttpStatus.NO_CONTENT, "No hay fotos");
        }
        fotosDTO = fotos.stream().map(foto -> {
            return modelMapper.map(foto, PhotoDTO.class);
        }).collect(Collectors.toList());

        return fotosDTO;
    }

    @Override
    public PhotoDTO save(PhotoDTO fotoDTO) {
        Photo foto = modelMapper.map(fotoDTO,Photo.class);
        foto = fotoDao.save(foto);
        PhotoDTO fotoDto = modelMapper.map(foto, PhotoDTO.class);
        return fotoDto;
    }

    @Override
    public PhotoDTO findById(String id) {
        PhotoDTO fotoDTO = null;
        Photo foto = fotoDao.findById(id).orElse(null);
        if(foto == null){
            throw new PhotoException(HttpStatus.NOT_FOUND , "La foto no existe en la bd");
        }
        fotoDTO = modelMapper.map(foto, PhotoDTO.class);
        return fotoDTO;
    }

    @Override
    public PhotoDTO update(String id,PhotoDTO fotoDTO) {
        Photo foto = fotoDao.findById(id).orElse(null);
        if(foto == null){
            throw new PhotoException(HttpStatus.NOT_FOUND,"La foto no existe");
        }
        foto = modelMapper.map(fotoDTO, Photo.class);
        fotoDao.save(foto);
        return fotoDTO;
    }

    @Override
    public void delete(String id) {
        Photo foto = fotoDao.findById(id).orElse(null);
        if(foto == null){
            throw new PhotoException(HttpStatus.BAD_REQUEST, "La foto no existe en la bd");
        }
        fotoDao.delete(foto);
    }

}
