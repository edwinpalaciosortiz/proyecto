package com.clase.proyecto.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "tb_obra")
@Getter
@Setter
@AllArgsConstructor
public class Obra {

    @Id
    String id;

    String nombre;
    String autor;
    String materiales;
    String tipo;
    Double precio;
    Date fechapublicacion;

}
