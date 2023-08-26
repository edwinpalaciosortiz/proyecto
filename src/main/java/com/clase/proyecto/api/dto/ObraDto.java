package com.clase.proyecto.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ObraDto {
    String id;

    String nombre;
    String autor;
    Double precio;
    String tipo;

}
