package com.clase.proyecto.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CreateObraDto {

    @NotNull
    @NotBlank
    String nombre;

    @NotNull
    @NotBlank
    String autor;

    @NotNull
    @NotBlank
    String materiales;

    @NotNull
    @Min(0)
    Double precio;

    @NotNull
    @NotBlank
    String tipo;

    @NotNull
    LocalDate fechaCreacion;

}
