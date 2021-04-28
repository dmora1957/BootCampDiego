package com.studentdraw.demo.controllers;

import com.studentdraw.demo.dtos.StudentDto;
import com.studentdraw.demo.entities.Student;
import com.studentdraw.demo.services.IStudentService;
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
    public ResponseEntity generateStudents(@RequestParam int quantity)  {
        return new ResponseEntity<>( _service.generateStudents(quantity), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getStudent(@RequestParam int quantity)   {
        return new ResponseEntity<>( this._service.returnStudentDraw(quantity), HttpStatus.OK);
    }
}
