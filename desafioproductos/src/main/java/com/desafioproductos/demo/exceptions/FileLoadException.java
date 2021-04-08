package com.desafioproductos.demo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FileLoadException extends GenericException{

    public FileLoadException(String msg)
    {
        super(msg);
        statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
