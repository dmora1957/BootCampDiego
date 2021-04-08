package com.desafioproductos.demo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ArticleNotFoundException extends GenericException{

    public ArticleNotFoundException(int id)
    {
        super("identifier "+id+" not found");
        statusCode = HttpStatus.NOT_FOUND;
    }
}
