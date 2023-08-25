package com.clase.proyecto.domain.service;

import com.clase.proyecto.api.dto.CreateObraDto;
import com.clase.proyecto.domain.models.Obra;
import com.clase.proyecto.domain.repository.ObraRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObraServiceImplTest {

    @Mock()
    private ObraRepository obraRepository;

    @InjectMocks
    private ObraServiceImpl obraServiceImp;
    @Test
    void crearObrar() {

        ResponseEntity<?> response =  obraServiceImp.crearObrar(
                CreateObraDto.builder()
                        .autor("Edwin")
                        .nombre("obra 1")
                        .tipo("fictica")
                        .fechaCreacion(LocalDate.now())
                        .precio(0.0)
                        .materiales("Imaginación")
                        .build()
                );
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode().value());
    }
    @Test
    void crearObrarRepetida() {

        when(obraRepository.findByNombre(anyString())).thenReturn(Optional.of( new Obra()));

        ResponseEntity<?> response = obraServiceImp.crearObrar(CreateObraDto.builder()
                .autor("edwin")
                .nombre("obra 1")
                .tipo("fictica")
                .fechaCreacion(LocalDate.now())
                .precio(0.0)
                .materiales("Imaginación")
                .build()
        );

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode().value());
    }
}
