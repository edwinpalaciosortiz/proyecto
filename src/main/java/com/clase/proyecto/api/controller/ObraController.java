package com.clase.proyecto.api.controller;

import com.clase.proyecto.api.dto.ResponseMessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/obra")
public class ObraController {

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessageDTO>  eliminarObra(@PathVariable String id){
        return ResponseEntity.ok(ResponseMessageDTO.builder()
                        .message("Obra eliminada correctamente")
                .build());
    }

    @PostMapping("/")
    public ResponseEntity<String> crearObra(){
        return  ResponseEntity.ok("Ok");
    }

    @GetMapping ("/listarObras")
    public ResponseEntity<String> listarObras(){
        return  ResponseEntity.ok("Ok");
    }
}
