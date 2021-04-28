package com.appconsultoriomysql.demo.controllers;

import com.appconsultoriomysql.demo.entities.Student;
import com.appconsultoriomysql.demo.services.StudentService;
import com.appconsultoriomysql.demo.services.interfaces.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Student")
public class StudentControlller {

    private final IStudentService _service;

    public StudentControlller(IStudentService service) {
        this._service = service;
    }

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody Student student)  {
        return new ResponseEntity<>( _service.save(student), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getStudents()  {
        return new ResponseEntity<>( this._service.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getStudent(@RequestParam Long id)  {
        return new ResponseEntity<>( this._service.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateStudent(@RequestParam Long id, @RequestBody Student student)  {
        //_service.(id, student);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity updateStudentName(@RequestParam Long id, @RequestBody Student student)  {
        //_service.(id, student);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
