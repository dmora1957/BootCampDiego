package com.calculadoracalorias.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDto {
    private Integer totalCaloriesAmount;
    private List<ResponseIngredientDto> ingredientCaloriesAmount;
    private ResponseIngredientDto highestCaloriesIngredient;
}
