package com.diploma.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AsignaturaDto {
    private String nombre;
    private int nota;
}
