package com.servicios.demo.Controllers;

import com.servicios.demo.dto.PotterDto;
import com.servicios.demo.dto.SimpsonDto;
import com.servicios.demo.services.PersonajeServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    @GetMapping("/{nombre}")
    public ResponseEntity obtenerInfo(@PathVariable String nombre)
    {
        return PersonajeServices.buscarPersonaje(nombre);
    }

    @PostMapping("/homero")
    public ResponseEntity enviarSimpson(@RequestBody SimpsonDto personaje)
    {
        return PersonajeServices.mapearSimpson(personaje);
    }

    @PostMapping("/harry")
    public ResponseEntity enviarHarry(@RequestBody PotterDto personaje)
    {
        return PersonajeServices.mapearPotter(personaje);
    }
}
