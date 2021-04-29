package com.consultoriodentista.demo.controllers;

import com.consultoriodentista.demo.dtos.PatientDTO;
import com.consultoriodentista.demo.dtos.StatusDTO;
import com.consultoriodentista.demo.dtos.TurnDTO;
import com.consultoriodentista.demo.exceptions.*;
import com.consultoriodentista.demo.services.interfaces.IPatientService;
import com.consultoriodentista.demo.services.interfaces.ITurnService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/turn")
public class TurnsController {

    private final ITurnService _service;

    public TurnsController(ITurnService service) {
        this._service = service;
    }

    @PostMapping
    public ResponseEntity addTurn(@RequestBody TurnDTO student) throws DairyNotFoundException, PatientNotFoundException, TurnStatusValidationNotFoundException {
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

    @GetMapping("byStatus")
    public ResponseEntity getTurnByStatus(@RequestParam Long statusId) throws TurnNotFoundException {
        return new ResponseEntity<>( this._service.findAllByStatus(statusId), HttpStatus.OK);
    }

    @GetMapping("byDateAndStatus")
    public ResponseEntity getTurnByDateAndStatus(@RequestParam Long statusId, @RequestParam String date) throws TurnNotFoundException, ParseException {
        return new ResponseEntity<>( this._service.findAllByStatusAndDate(statusId, date), HttpStatus.OK);
    }

    @GetMapping("patients/{date}")
    public ResponseEntity getTurn(@RequestParam String date) throws ParseException {
        return new ResponseEntity<>( this._service.findPatientsByDate(date), HttpStatus.OK);
    }

    @PostMapping("change-status")
    public ResponseEntity getTurn(@RequestParam Long id, @RequestParam Long status)  {
        return new ResponseEntity<>( this._service.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteTurn(@RequestParam Long id)  {
        this._service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("ByDentist")
    public ResponseEntity getTurnByDentist(@RequestParam Long id) throws ParseException, DentistNotFoundException {
        return new ResponseEntity<>( this._service.findTurnsByDentist(id), HttpStatus.OK);
    }
}
