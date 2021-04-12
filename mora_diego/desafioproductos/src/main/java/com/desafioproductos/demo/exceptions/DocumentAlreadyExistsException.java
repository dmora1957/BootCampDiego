package com.desafioproductos.demo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DocumentAlreadyExistsException extends GenericException{

    public DocumentAlreadyExistsException(String msg)
    {
        super(msg);
        statusCode = HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
