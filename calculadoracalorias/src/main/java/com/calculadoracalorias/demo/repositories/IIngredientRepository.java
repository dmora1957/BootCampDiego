package com.calculadoracalorias.demo.repositories;

import com.calculadoracalorias.demo.entities.IngredientNutritionalInfoDto;
import com.calculadoracalorias.demo.exceptions.IngredientNotFound;

public interface IIngredientRepository {
    public IngredientNutritionalInfoDto findCaloriesByFood(String food) throws IngredientNotFound;
}
