package com.calculadoracalorias.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DishDto {
    private String name;
    private List<IngredientDto> ingredients;
}
