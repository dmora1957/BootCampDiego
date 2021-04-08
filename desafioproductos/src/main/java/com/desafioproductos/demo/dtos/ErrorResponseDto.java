package com.desafioproductos.demo.dtos;

import com.desafioproductos.demo.exceptions.GenericException;
import lombok.Data;

@Data
public class ErrorResponseDto {

    private String name;
    private String description;

    public ErrorResponseDto(GenericException exc)
    {
        name = exc.getName();
        description = exc.getMessage();
    }
}
