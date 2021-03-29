package com.servicios.demo.dto;

import java.util.List;

public class SimpsonDto {
    private String nombre;
    private String apellido;
    private List<String> hijos;
    private int edad;
    private boolean esposa;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<String> getHijos() {
        return hijos;
    }

    public void setHijos(List<String> hijos) {
        this.hijos = hijos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isEsposa() {
        return esposa;
    }

    public void setEsposa(boolean esposa) {
        this.esposa = esposa;
    }

    public SimpsonDto(String nombre, String apellido, List<String> hijos, int edad, boolean esposa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.hijos = hijos;
        this.edad = edad;
        this.esposa = esposa;
    }
}
