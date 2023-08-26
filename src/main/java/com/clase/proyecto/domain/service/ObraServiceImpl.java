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
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

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

        List<ObraDto> todas = StreamSupport.stream(obraRepository.findAll().spliterator(),false)
                .map(obra ->
                    ObraDto.builder()
                                    .id(obra.getId())
                                    .nombre(obra.getNombre())
                                    .autor(obra.getAutor())
                                    .precio(obra.getPrecio())
                                    .tipo(obra.getTipo())
                            .build()
                ).toList();

        if(todas.isEmpty()){
            throw new IllegalArgumentException("no hay ninguna obra para mostrar");
        }

        return todas;
        //return new ArrayList<ObraDto>();
    };
    @Override
    public String eliminarObra(String idObra){
        if (idObra.isBlank())
            throw new RuntimeException("El ID de la obra no puede estar vacio");

        return obraRepository.findById(idObra)
                .map(Obra::getId)
                .map(id -> {
                    obraRepository.deleteById(id);
                    return "La obra con id ".concat(idObra).concat(" fue eliminada correctamente");
                })
                .orElseThrow(() ->  new RuntimeException("La obra que intenta eliminar no existe"));
    }

}
