package com.linktracker.demo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LinkException extends Exception{
    protected String name;
    protected HttpStatus statusCode;
    public LinkException(String msg)
    {
        super(msg);
    }
}
