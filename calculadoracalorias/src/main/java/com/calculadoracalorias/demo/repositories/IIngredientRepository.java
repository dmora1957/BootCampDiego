package com.calculadoracalorias.demo.repositories;

import com.calculadoracalorias.demo.entities.IngredientNutritionalInfoDto;

public interface IIngredientRepository {
    public IngredientNutritionalInfoDto findCaloriesByFood(String food);
}
