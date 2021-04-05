package com.calculadoracalorias.demo.repositories;

import com.calculadoracalorias.demo.entities.IngredientNutritionalInfoDto;
import com.calculadoracalorias.demo.exceptions.IngredientNotFound;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepository implements IIngredientRepository{

    @Override
    public IngredientNutritionalInfoDto findCaloriesByFood(String food) throws IngredientNotFound {
        List<IngredientNutritionalInfoDto> ingredientDtos = null;
        ingredientDtos = loadDataBase();
        IngredientNutritionalInfoDto result = null;

        if(ingredientDtos != null){
            Optional<IngredientNutritionalInfoDto> item = ingredientDtos.stream()
                    .filter(priceDto -> priceDto.getName().equals(food))
                    .findFirst();

            if(item.isPresent())
            {
                result = item.get();
            }
            else
            {
                throw new IngredientNotFound(food);
            }
        }
        return result;
    }

    private List<IngredientNutritionalInfoDto> loadDataBase() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:food.json");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        ObjectMapper om = new ObjectMapper();
        TypeReference<List<IngredientNutritionalInfoDto>> typeRef = new TypeReference<>(){};
        List<IngredientNutritionalInfoDto> ingredientDtos = null;

        try{
            ingredientDtos = om.readValue(file, typeRef);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return ingredientDtos;
    }
}
