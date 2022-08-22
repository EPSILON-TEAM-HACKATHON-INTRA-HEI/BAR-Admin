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

    @PostMapping("/drinks")
    public Drinks AddNewDrink (@RequestBody Drinks drinks){
        return drinkService.save(drinks);
    }
    @GetMapping("/drinks")
    public List<Drinks> getDrinks()
    /**(int page, int pageSize)**/{
        return drinkService.getAll();
    }
    @GetMapping("/drinks/{drinksId}")
    public Drinks getDrinkById (@PathVariable Integer drinksId){
        return drinkService.getById(drinksId);
    }
    @DeleteMapping("/drinks/{id}")
    public String deleteDrinkById(@PathVariable Integer id){
        return drinkService.deleteById(id);
    }
    @PatchMapping("/drinks")
    public Drinks updateName(
            @RequestParam(name = "id") Integer id,
            @RequestParam(name = "name") Long newPrice)
    {
        return drinkService.updatePrice(id, newPrice);
    }
}
