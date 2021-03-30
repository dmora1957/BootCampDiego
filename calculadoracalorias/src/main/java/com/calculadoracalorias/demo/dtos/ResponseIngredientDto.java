package com.calculadoracalorias.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class ResponseIngredientDto {
    private String name;
    private int weight;
    private int calories;
}
