package com.consultoriodentista.demo.controllers;

import com.consultoriodentista.demo.dtos.DentistDTO;
import com.consultoriodentista.demo.dtos.PatientDTO;
import com.consultoriodentista.demo.services.interfaces.IDentistService;
import com.consultoriodentista.demo.services.interfaces.IPatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final IPatientService _service;

    public PatientController(IPatientService service) {
        this._service = service;
    }

    @PostMapping
    public ResponseEntity addPatient(@RequestBody PatientDTO student)  {
        return new ResponseEntity<>( _service.save(student), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getPatients()  {
        return new ResponseEntity<>( this._service.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getPatient(@RequestParam Long id)  {
        return new ResponseEntity<>( this._service.findById(id), HttpStatus.OK);
    }

}
