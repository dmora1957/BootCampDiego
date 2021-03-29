package com.servicios.demo.dto;

import java.util.List;

public class PotterDto {
    private String nombre;
    private List<String> Colores;

    public PotterDto(String nombre, List<String> colores, List<EstudianteDto> integrantes) {
        this.nombre = nombre;
        Colores = colores;
        this.integrantes = integrantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getColores() {
        return Colores;
    }

    public void setColores(List<String> colores) {
        Colores = colores;
    }

    public List<EstudianteDto> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<EstudianteDto> integrantes) {
        this.integrantes = integrantes;
    }

    private List<EstudianteDto> integrantes;
}
