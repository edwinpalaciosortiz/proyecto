package com.clase.proyecto.api;

import com.clase.proyecto.api.dto.ResponseMessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExceptionsResponse {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseMessageDTO> handlerRuntimeExceptions(Exception exception){
        return ResponseEntity.internalServerError()
                .body(ResponseMessageDTO.builder()
                        .message(exception.getMessage())
                        .build());
    }
}
