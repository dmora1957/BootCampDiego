package com.consultoriodentista.demo.controllers;

import com.consultoriodentista.demo.dtos.StatusDTO;
import com.consultoriodentista.demo.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.ParseException;

@ControllerAdvice
public class ExceptionHelper {
    @ExceptionHandler(DairyNotFoundException.class)
    public ResponseEntity invalidDate(DairyNotFoundException n) {
        StatusDTO error = new StatusDTO();
        error.setCode(400);
        error.setMessage(n.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity invalidPatient(PatientNotFoundException n) {
        StatusDTO error = new StatusDTO();
        error.setCode(400);
        error.setMessage(n.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<StatusDTO> handleUnknownException() {
        StatusDTO error = new StatusDTO();
        error.setCode(500);
        error.setMessage("Internal error, please contact application admin");
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(TurnStatusValidationNotFoundException.class)
    public ResponseEntity invalidPatient(TurnStatusValidationNotFoundException n) {
        StatusDTO error = new StatusDTO();
        error.setCode(400);
        error.setMessage(n.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TurnStatusNotFoundException.class)
    public ResponseEntity invalidPatient(TurnStatusNotFoundException n) {
        StatusDTO error = new StatusDTO();
        error.setCode(400);
        error.setMessage(n.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TurnValidationNotFoundException.class)
    public ResponseEntity invalidPatient(TurnValidationNotFoundException n) {
        StatusDTO error = new StatusDTO();
        error.setCode(400);
        error.setMessage(n.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TurnNotFoundException.class)
    public ResponseEntity invalidPatient(TurnNotFoundException n) {
        StatusDTO error = new StatusDTO();
        error.setCode(400);
        error.setMessage(n.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ParseException.class)
    public ResponseEntity invalidPatient(ParseException n) {
        StatusDTO error = new StatusDTO();
        error.setCode(400);
        error.setMessage(n.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DentistNotFoundException.class)
    public ResponseEntity invalidPatient(DentistNotFoundException n) {
        StatusDTO error = new StatusDTO();
        error.setCode(400);
        error.setMessage(n.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}
