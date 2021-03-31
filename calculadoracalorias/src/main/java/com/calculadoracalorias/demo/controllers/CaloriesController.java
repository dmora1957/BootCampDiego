package com.calculadoracalorias.demo.controllers;

import com.calculadoracalorias.demo.dtos.DishDto;
import com.calculadoracalorias.demo.dtos.ErrorDto;
import com.calculadoracalorias.demo.exceptions.IngredientNotFound;
import com.calculadoracalorias.demo.services.IngredientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calories")
public class CaloriesController {

    @Autowired
    private IngredientServices services;

    @PostMapping("/calculateSingleDish")
    public ResponseEntity getCalories(@RequestBody DishDto dish) throws IngredientNotFound {
        return new ResponseEntity(services.calculate(dish),HttpStatus.OK);
    }

    @PostMapping("/calculateMultipleDish")
    public ResponseEntity getCaloriesByList(@RequestBody List<DishDto> dishes) throws IngredientNotFound {
        return new ResponseEntity(services.calculate(dishes),HttpStatus.OK);
    }

    @ExceptionHandler(IngredientNotFound.class)
    public ResponseEntity<ErrorDto> handleException(IngredientNotFound errorException)
    {
        var error = new ErrorDto(errorException.getMessage(), "Ingredient Not found");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
