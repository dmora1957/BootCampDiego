package com.consultoriodentista.demo.controllers;

import com.consultoriodentista.demo.dtos.DairyDTO;
import com.consultoriodentista.demo.services.interfaces.IDairyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class GroupController {

    @GetMapping
    public ResponseEntity getGroup()  {
        return new ResponseEntity<>( "Grupo 6", HttpStatus.OK);
    }

}
