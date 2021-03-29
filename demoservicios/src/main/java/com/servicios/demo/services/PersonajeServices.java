package com.servicios.demo.services;

import com.servicios.demo.dto.EstudianteDto;
import com.servicios.demo.dto.PotterDto;
import com.servicios.demo.dto.SimpsonDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class PersonajeServices {

    public static ResponseEntity buscarPersonaje(String nombre)
    {
       if(nombre.equals("harry"))
       {
           List<String> colores = new ArrayList<>();
           colores.add("Amarillo");
           colores.add("Bordo");

           List<EstudianteDto> integrantes = new ArrayList<>();
           integrantes.add(new EstudianteDto("Harry", "Potter"));
           integrantes.add(new EstudianteDto("Hermione", "Granger"));
           integrantes.add(new EstudianteDto("Ron", "Weasley"));

           PotterDto harry = new PotterDto("Gryffindor", colores, integrantes);

           return  new ResponseEntity(harry, HttpStatus.OK);
       }
       else
       {
           List<String> hijos = new ArrayList<>();
           hijos.add("Bart");
           hijos.add("Lisa");
           hijos.add("Maggie");

           SimpsonDto homero = new SimpsonDto("Homero", "Simpson", hijos,40,true);

           return new ResponseEntity(homero, HttpStatus.OK);
       }
    }

    public static ResponseEntity mapearSimpson(SimpsonDto personaje) {

        return new ResponseEntity(personaje,HttpStatus.OK);
    }

    public static ResponseEntity mapearPotter(PotterDto personaje) {

        return new ResponseEntity(personaje,HttpStatus.OK);
    }
}
