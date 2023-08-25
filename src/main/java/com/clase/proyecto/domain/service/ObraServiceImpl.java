package com.clase.proyecto.domain.service;

import com.clase.proyecto.api.dto.CreateObraDto;
import com.clase.proyecto.api.dto.ObraDto;
import com.clase.proyecto.domain.models.Obra;
import com.clase.proyecto.domain.repository.ObraRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Getter
@Setter
public class ObraServiceImpl implements ObraService{

    @Autowired
    private ObraRepository obraRepository;

    @Override
    public ResponseEntity<?> crearObrar(CreateObraDto createObraDto) throws IllegalArgumentException {


        boolean obraExiste = obraRepository.findByNombre(createObraDto.getNombre()).isPresent();
        if(obraExiste) return new ResponseEntity<>("Err: esta obra ya existe, no es posible crearla :(", HttpStatus.BAD_REQUEST);

        Obra obra = new Obra(UUID.randomUUID().toString(),
                createObraDto.getNombre(),
                createObraDto.getAutor(),
                createObraDto.getMateriales(),
                createObraDto.getTipo(),
                createObraDto.getPrecio(),
                LocalDate.now(),
                createObraDto.getFechaCreacion());

        obraRepository.save(obra);
        return new ResponseEntity<>("Creado satisfactoriamente", HttpStatus.CREATED);
    }

    @Override
    public List<ObraDto> listarObras(){

        return new ArrayList<ObraDto>();
    };
    @Override
    public void eliminarObra(String idObra){
        obraRepository.deleteById(idObra);
    };

}
