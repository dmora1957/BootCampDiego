package com.desafioproductos.demo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EmptyResponseException extends GenericException{

    public EmptyResponseException(String msg)
    {
        super(msg);
        statusCode = HttpStatus.OK;
    }
}
