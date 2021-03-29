package com.diploma.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EstudianteDto {
    private String nombre;
    private List<AsignaturaDto> asignaturas;
}
