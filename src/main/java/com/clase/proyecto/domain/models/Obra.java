package com.clase.proyecto.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "tb_obra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Obra {


    @Id
    String id;

    String nombre;
    String autor;
    String materiales;
    String tipo;
    Double precio;
    LocalDate fechapublicacion;
    LocalDate fechaCreacion;

}
