package com.photoservice.photo.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "images")
public class Photo {
        @Id
        private String id;
        private String nombre;
        private String contenido;
        private String tipoContenido;
}
