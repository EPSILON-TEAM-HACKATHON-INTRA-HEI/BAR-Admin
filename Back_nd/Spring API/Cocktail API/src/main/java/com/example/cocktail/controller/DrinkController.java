package com.example.cocktail.controller;

import com.example.cocktail.model.Drinks;
import com.example.cocktail.service.DrinkService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class DrinkController {
    private DrinkService drinkService;

    @GetMapping("/drinks")
    public List<Drinks> getDrinks(){
        return drinkService.getAll();
    }
    @GetMapping("/drinks/{drinksId}")
    public Drinks getDrinkById (@PathVariable Integer drinksId){
        return drinkService.getById(drinksId);
    }
    @PostMapping("/drinks")
    public List<Drinks> addNewDrink (@RequestBody List<Drinks> drinks){
        return drinkService.saveAll(drinks);
    }
}
