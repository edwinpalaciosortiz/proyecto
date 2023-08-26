package com.clase.proyecto.domain.service;

import com.clase.proyecto.api.dto.CreateObraDto;
import com.clase.proyecto.api.dto.ObraDto;
import com.clase.proyecto.domain.models.Obra;
import com.clase.proyecto.domain.repository.ObraRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
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

    @Test
    void eliminarObra() {
        Obra obra = Obra.builder()
                .id("123")
                .autor("edwin")
                .nombre("obra 1")
                .tipo("fictica")
                .fechaCreacion(LocalDate.now())
                .precio(0.0)
                .materiales("Imaginación")
                .build();
        when(obraRepository.findById("123")).thenReturn(Optional.of(obra));

        String response = obraServiceImp.eliminarObra("123");

        assertTrue(response.equalsIgnoreCase("La obra con id 123 fue eliminada correctamente"));
    }

    @Test
    void eliminarObraNoExistente() {
        Obra obra = Obra.builder()
                .id("123")
                .autor("edwin")
                .nombre("obra 1")
                .tipo("fictica")
                .fechaCreacion(LocalDate.now())
                .precio(0.0)
                .materiales("Imaginación")
                .build();

        Throwable exception = assertThrows(RuntimeException.class, () ->
            obraServiceImp.eliminarObra("987")
        );

        assertTrue(exception.getMessage().equalsIgnoreCase("La obra que intenta eliminar no existe"));
    }

    @Test
    void eliminarObraConIdVacio() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
            obraServiceImp.eliminarObra("")
        );

        assertTrue(exception.getMessage().equalsIgnoreCase("El ID de la obra no puede estar vacio"));
    }

    @Test
    void listarObras(){

        List<ObraDto> obrasDTO = List.of(
                ObraDto.builder()
                        .id("test1")
                        .nombre("test")
                        .autor("test")
                        .precio(0.0)
                        .tipo("test")
                        .build()
        );

        Iterable<Obra> todas = List.of(
                Obra.builder()
                        .id("test1")
                        .nombre("test")
                        .autor("test")
                        .fechapublicacion(LocalDate.now())
                        .fechaCreacion(LocalDate.now())
                        .precio(0.0)
                        .tipo("test")
                        .build()
        );
        when(obraRepository.findAll()).thenReturn(todas);

        assertEquals(obrasDTO.get(0).getId(),obraServiceImp.listarObras().get(0).getId());
    }

    @Test
    void listarTodasSinObras(){

        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                obraServiceImp.listarObras()
        );

        assertTrue(exception.getMessage().equalsIgnoreCase("no hay ninguna obra para mostrar"));

    }
}
