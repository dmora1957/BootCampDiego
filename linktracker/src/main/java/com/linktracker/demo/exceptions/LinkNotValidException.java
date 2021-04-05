package com.linktracker.demo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LinkNotValidException extends LinkException{

    public LinkNotValidException(String msg)
    {
        super("url "+msg+" not valid");
        name = "Link Not Valid";
        statusCode = HttpStatus.BAD_REQUEST;
    }
}
