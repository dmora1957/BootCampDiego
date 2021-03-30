package com.calculadorametros.refactor.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CasaDto {

    private String nombre;
    private String direccion;
    private List<HabitacionDto> habitaciones;
    private String location;
}
