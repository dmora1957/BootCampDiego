package com.starwars.demo.controllers;

import com.starwars.demo.services.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharactersService services;

    @GetMapping("/byString/{name}")
    public ResponseEntity getCharacters(@PathVariable(value = "name") String name)
    {
        return new ResponseEntity(services.getCharacters(name), HttpStatus.OK);
    }
}
