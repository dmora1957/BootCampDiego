package com.desafioproductos.demo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotEnoughStockException extends GenericException{

    public NotEnoughStockException(String product)
    {
        super("Not enough stock of "+ product);
        statusCode = HttpStatus.CONFLICT;
    }
}
