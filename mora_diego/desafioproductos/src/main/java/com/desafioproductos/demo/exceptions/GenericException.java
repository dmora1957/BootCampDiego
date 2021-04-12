package com.desafioproductos.demo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericException extends Exception{
    protected String name;
    protected HttpStatus statusCode;
    public GenericException(String msg)
    {
        super(msg);
        this.name = this.getClass().getName();
    }
}
