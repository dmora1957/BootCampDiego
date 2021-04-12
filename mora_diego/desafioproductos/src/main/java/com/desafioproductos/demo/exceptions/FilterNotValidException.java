package com.desafioproductos.demo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FilterNotValidException extends GenericException{

    public FilterNotValidException(String msg)
    {
        super(msg);
        statusCode = HttpStatus.BAD_REQUEST;
    }
}
