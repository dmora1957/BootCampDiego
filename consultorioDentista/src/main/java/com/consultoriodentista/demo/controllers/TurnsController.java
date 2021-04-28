package com.consultoriodentista.demo.controllers;

import com.consultoriodentista.demo.dtos.PatientDTO;
import com.consultoriodentista.demo.dtos.TurnDTO;
import com.consultoriodentista.demo.services.interfaces.IPatientService;
import com.consultoriodentista.demo.services.interfaces.ITurnService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turn")
public class TurnsController {

    private final ITurnService _service;

    public TurnsController(ITurnService service) {
        this._service = service;
    }

    @PostMapping
    public ResponseEntity addTurn(@RequestBody TurnDTO student)  {
        return new ResponseEntity<>( _service.save(student), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTurns()  {
        return new ResponseEntity<>( this._service.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getTurn(@RequestParam Long id)  {
        return new ResponseEntity<>( this._service.findById(id), HttpStatus.OK);
    }

}
