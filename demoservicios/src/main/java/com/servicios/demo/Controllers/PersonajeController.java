package com.servicios.demo.Controllers;

import com.servicios.demo.dto.PotterDto;
import com.servicios.demo.dto.SimpsonDto;
import com.servicios.demo.services.PersonajeServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PostMapping("/harry2")
    public ResponseEntity enviarHarry2(@RequestBody PotterDto personaje, @RequestHeader Map<String,String> header)
    {
        header.forEach((key, value) ->{
            System.out.println(String.format("Parametros '%s' : %s", key, value));
        });
        return PersonajeServices.mapearPotter(personaje);
    }
}
