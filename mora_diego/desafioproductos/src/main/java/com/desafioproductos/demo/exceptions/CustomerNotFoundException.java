package com.desafioproductos.demo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomerNotFoundException extends GenericException{

    public CustomerNotFoundException(int id)
    {
        super("Customer identifier "+id+" not found");
        statusCode = HttpStatus.NOT_FOUND;
    }
}
