package com.consultoriodentista.demo.controllers;

import com.consultoriodentista.demo.dtos.DentistDTO;
import com.consultoriodentista.demo.services.interfaces.IDentistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private final IDentistService _service;

    public DentistController(IDentistService service) {
        this._service = service;
    }

    @PostMapping
    public ResponseEntity addDentist(@RequestBody DentistDTO student)  {
        return new ResponseEntity<>( _service.save(student), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getDentists()  {
        return new ResponseEntity<>( this._service.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getDentist(@RequestParam Long id)  {
        return new ResponseEntity<>( this._service.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteDentist(@RequestParam Long id)  {
        this._service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("more-than-two-turns/{date}")
    public ResponseEntity getTurn(@RequestParam String date) throws ParseException {
        return new ResponseEntity<>( this._service.findDentistWithMoreThanTwoTurns(date), HttpStatus.OK);
    }
}
