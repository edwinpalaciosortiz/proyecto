package com.clase.proyecto.api.controller;

import com.clase.proyecto.api.dto.CreateObraDto;
import com.clase.proyecto.api.dto.ResponseMessageDTO;
import com.clase.proyecto.domain.service.ObraService;
import com.clase.proyecto.domain.service.ObraServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obra")
public class ObraController {
    @Autowired
    private ObraService obraService;

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessageDTO>  eliminarObra(@PathVariable String id){
        return ResponseEntity.ok(ResponseMessageDTO.builder()
                        .message("Obra eliminada correctamente")
                .build());
    }

    @PostMapping("/")
    public ResponseEntity<?> crearObra(@Valid @RequestBody CreateObraDto createObraDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            List<String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .map(err -> {
                        return "ERROR en "+err.getField()+": "+err.getDefaultMessage();
                    })
                    .toList();
            return new ResponseEntity<>("err: no fue posible crear tu obra", HttpStatus.BAD_REQUEST);
        }

        return  obraService.crearObrar(createObraDto);

        //
    }

    @GetMapping ("/listarObras")
    public ResponseEntity<String> listarObras(){
        return  ResponseEntity.ok("Ok");
    }
}
