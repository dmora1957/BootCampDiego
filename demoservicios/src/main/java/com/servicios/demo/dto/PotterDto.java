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

    private List<EstudianteDto> integrantes;
}
