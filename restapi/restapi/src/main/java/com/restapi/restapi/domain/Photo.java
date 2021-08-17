package com.restapi.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Photo implements Serializable {

    private String id;
    private String nombre;
    private String contenido;
    private String tipoContenido;

}