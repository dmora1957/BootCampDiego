package com.consultoriodentista.demo.controllers;

import com.consultoriodentista.demo.dtos.DairyDTO;
import com.consultoriodentista.demo.dtos.TurnStatusDTO;
import com.consultoriodentista.demo.services.interfaces.IDairyService;
import com.consultoriodentista.demo.services.interfaces.ITurnStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dairy")
public class DairyController {

    private final IDairyService _service;

    public DairyController(IDairyService service) {
        this._service = service;
    }

    @PostMapping
    public ResponseEntity addDairy(@RequestBody DairyDTO student)  {
        return new ResponseEntity<>( _service.save(student), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getDairies()  {
        return new ResponseEntity<>( this._service.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getDairy(@RequestParam Long id)  {
        return new ResponseEntity<>( this._service.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteDairy(@RequestParam Long id)  {
        this._service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
