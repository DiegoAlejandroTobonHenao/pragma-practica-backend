package com.photoservice.photo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhotoDTO {

    private String id;
    private String nombre;
    private String contenido;
    private String tipoContenido;
}
