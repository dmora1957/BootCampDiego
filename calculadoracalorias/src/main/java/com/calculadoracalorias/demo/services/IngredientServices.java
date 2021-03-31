package com.calculadoracalorias.demo.services;

import com.calculadoracalorias.demo.dtos.DishDto;
import com.calculadoracalorias.demo.dtos.IngredientDto;
import com.calculadoracalorias.demo.dtos.ResponseDto;
import com.calculadoracalorias.demo.dtos.ResponseIngredientDto;
import com.calculadoracalorias.demo.entities.IngredientNutritionalInfoDto;
import com.calculadoracalorias.demo.exceptions.IngredientNotFound;
import com.calculadoracalorias.demo.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientServices {

    @Autowired
    private IngredientRepository ingredientRepository;
    
    public ResponseDto calculate(DishDto unPlato) throws IngredientNotFound {
        var totalCalories = 0;
        List<ResponseIngredientDto> ingredientsWithCalories = new ArrayList<>();
        ResponseIngredientDto greaterCalories = new ResponseIngredientDto("",0,0);
        for (var ing:unPlato.getIngredients()) {

            IngredientNutritionalInfoDto currentIngredient = ingredientRepository.findCaloriesByFood(ing.getName());
            var caloriesPerHundred = currentIngredient != null ? currentIngredient.getCalories() : 0;
            var currentCalories = caloriesPerHundred*ing.getWeight()/100;
            totalCalories+=currentCalories;
            var calculatedIngredient = new ResponseIngredientDto(ing.getName(), ing.getWeight(),currentCalories);
            ingredientsWithCalories.add(calculatedIngredient);
            if(calculatedIngredient.getCalories() > greaterCalories.getCalories())
            {
                greaterCalories = calculatedIngredient;
            }
        }
        return new ResponseDto(totalCalories, ingredientsWithCalories,greaterCalories);
    }

    public List<ResponseDto> calculate(List<DishDto> platos) throws IngredientNotFound {
    var results = new ArrayList<ResponseDto>();

        for (var p:platos) {
            var result = calculate(p);
            results.add(result);
        }

        return results;
    }
}
