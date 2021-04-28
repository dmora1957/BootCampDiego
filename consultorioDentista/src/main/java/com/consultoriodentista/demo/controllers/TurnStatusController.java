package com.consultoriodentista.demo.controllers;

import com.consultoriodentista.demo.dtos.TurnDTO;
import com.consultoriodentista.demo.dtos.TurnStatusDTO;
import com.consultoriodentista.demo.services.interfaces.ITurnService;
import com.consultoriodentista.demo.services.interfaces.ITurnStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turn-status")
public class TurnStatusController {

    private final ITurnStatusService _service;

    public TurnStatusController(ITurnStatusService service) {
        this._service = service;
    }

    @PostMapping
    public ResponseEntity addTurnStatus(@RequestBody TurnStatusDTO student)  {
        return new ResponseEntity<>( _service.save(student), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTurnStatus()  {
        return new ResponseEntity<>( this._service.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getTurnStatus(@RequestParam Long id)  {
        return new ResponseEntity<>( this._service.findById(id), HttpStatus.OK);
    }

}
