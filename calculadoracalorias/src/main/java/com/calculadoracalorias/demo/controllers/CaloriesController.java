package com.calculadoracalorias.demo.controllers;

import com.calculadoracalorias.demo.dtos.DishDto;
import com.calculadoracalorias.demo.services.IngredientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calories")
public class CaloriesController {

    @Autowired
    private IngredientServices services;

    @PostMapping("/calculateSingleDish")
    public ResponseEntity getCalories(@RequestBody DishDto dish)
    {
        return new ResponseEntity(services.calculate(dish),HttpStatus.OK);
    }

    @PostMapping("/calculateMultipleDish")
    public ResponseEntity getCaloriesByList(@RequestBody List<DishDto> dishes)
    {
        return new ResponseEntity(services.calculate(dishes),HttpStatus.OK);
    }
}
