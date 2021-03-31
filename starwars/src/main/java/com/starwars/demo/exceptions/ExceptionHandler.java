package com.starwars.demo.exceptions;

public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public void nullPointerHandler()
    {
        logger.log(System.Logger.Level.ERROR, "Excepcion");
    }
}
