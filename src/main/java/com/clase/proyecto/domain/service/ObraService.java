package com.clase.proyecto.domain.service;

import com.clase.proyecto.api.dto.CreateObraDto;
import com.clase.proyecto.api.dto.ObraDto;
import com.clase.proyecto.domain.models.Obra;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ObraService{
    ResponseEntity<?> crearObrar(CreateObraDto createObraDto) throws IllegalArgumentException;


    List<ObraDto> listarObras();

    String eliminarObra(String idObra);

    //public List<ObraDto> listarObras();
    //public void eliminarObra(String idObra);
}
