package com.clase.proyecto.domain.service;

import com.clase.proyecto.api.dto.ObraDto;
import com.clase.proyecto.domain.models.Obra;
import com.clase.proyecto.domain.repository.ObraRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class ObraServiceImpl implements ObraService{

    @Autowired
    private ObraRepository obraRepository;

    public void crearObra(ObraDto obraDto){

    };
    public List<ObraDto> listarObras(){

        return new ArrayList<ObraDto>();
    };
    public void eliminarObra(String idObra){
        obraRepository.deleteById(idObra);
    };

}
