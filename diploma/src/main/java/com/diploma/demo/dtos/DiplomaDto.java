package com.diploma.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DiplomaDto {
    private String alumno;
    private String mensaje;
    private int notaPromedio;
}
