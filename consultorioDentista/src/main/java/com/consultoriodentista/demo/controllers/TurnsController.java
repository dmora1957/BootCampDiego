package com.consultoriodentista.demo.controllers;

import com.consultoriodentista.demo.dtos.PatientDTO;
import com.consultoriodentista.demo.dtos.StatusDTO;
import com.consultoriodentista.demo.dtos.TurnDTO;
import com.consultoriodentista.demo.exceptions.DairyNotFoundException;
import com.consultoriodentista.demo.exceptions.PatientNotFoundException;
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
    public ResponseEntity addTurn(@RequestBody TurnDTO student) throws DairyNotFoundException, PatientNotFoundException {
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

    @ExceptionHandler(DairyNotFoundException.class)
    public ResponseEntity invalidDate(DairyNotFoundException n)
    {
        StatusDTO error= new StatusDTO();
        error.setCode(400);
        error.setMessage(n.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity invalidPatient(PatientNotFoundException n)
    {
        StatusDTO error= new StatusDTO();
        error.setCode(400);
        error.setMessage(n.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<StatusDTO> handleUnknownException() {
        StatusDTO error= new StatusDTO();
        error.setCode(500);
        error.setMessage("Internal error, please contact application admin");
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);

    }


}
