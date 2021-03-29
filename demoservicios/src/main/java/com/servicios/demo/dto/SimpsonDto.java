package com.servicios.demo.dto;

import java.util.List;

public class SimpsonDto {
    private String nombre;
    private String apellido;
    private List<String> hijos;
    private int edad;
    private boolean esposa;

    public SimpsonDto(String nombre, String apellido, List<String> hijos, int edad, boolean esposa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.hijos = hijos;
        this.edad = edad;
        this.esposa = esposa;
    }
}
