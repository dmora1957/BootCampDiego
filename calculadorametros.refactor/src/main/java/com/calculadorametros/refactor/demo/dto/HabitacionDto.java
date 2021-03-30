package com.calculadorametros.refactor.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HabitacionDto {

    private String nombre;
    private int largo;
    private int ancho;

    public int getArea()
    {
        return this.largo*this.ancho;
    }
}
