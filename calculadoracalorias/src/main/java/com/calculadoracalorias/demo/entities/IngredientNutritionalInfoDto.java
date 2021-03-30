package com.calculadoracalorias.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientNutritionalInfoDto {
    private String name;
    private int calories;
}
