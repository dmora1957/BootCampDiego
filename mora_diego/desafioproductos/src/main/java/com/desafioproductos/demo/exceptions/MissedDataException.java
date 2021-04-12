package com.desafioproductos.demo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MissedDataException extends GenericException{

    public MissedDataException(String msg)
    {
        super(msg);
        statusCode = HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
