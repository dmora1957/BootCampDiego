package com.diploma.demo.Controllers;

import com.diploma.demo.Services.DiplomaServices;
import com.diploma.demo.dtos.EstudianteDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diploma")
public class DiplomaController {

    @PostMapping("getDiploma")
    public ResponseEntity getDiploma(@RequestBody EstudianteDto estudiante)
    {
        return new ResponseEntity(DiplomaServices.getDiploma(estudiante), HttpStatus.OK);
    }
}
