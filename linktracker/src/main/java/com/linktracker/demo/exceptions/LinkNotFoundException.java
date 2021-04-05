package com.linktracker.demo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LinkNotFoundException extends LinkException{

    public LinkNotFoundException(int id)
    {
        super("identifier "+id+" not found");
        name = "Link Not Found";
        statusCode = HttpStatus.NOT_FOUND;
    }
}
