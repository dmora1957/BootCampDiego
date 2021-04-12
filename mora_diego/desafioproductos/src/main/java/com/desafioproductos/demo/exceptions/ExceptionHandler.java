package com.desafioproductos.demo.exceptions;

import com.desafioproductos.demo.dtos.ErrorResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorResponseDto> handleException(GenericException errorException)
    {
        var error = new ErrorResponseDto(errorException);
        return new ResponseEntity<>(error, errorException.getStatusCode());
    }
}
