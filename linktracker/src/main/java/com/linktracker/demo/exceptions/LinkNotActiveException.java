package com.linktracker.demo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LinkNotActiveException extends LinkException{

    public LinkNotActiveException(String msg)
    {
        super("url "+msg+" not active");
        name = "Link Not Active";
        statusCode = HttpStatus.FORBIDDEN;
    }
}
