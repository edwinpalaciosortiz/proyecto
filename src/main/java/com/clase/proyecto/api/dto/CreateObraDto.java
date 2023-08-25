package com.clase.proyecto.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateObraDto {

    String nombre;
    String autor;
    LocalDate fechaPublicacion;
    String materiales;
    Double precio;
    String Tipo;
    LocalDate fechaCreacioon = LocalDate.now();
}
