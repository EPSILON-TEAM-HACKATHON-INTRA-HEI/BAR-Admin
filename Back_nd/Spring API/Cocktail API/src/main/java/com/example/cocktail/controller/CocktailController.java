package com.example.cocktail.controller;

import com.example.cocktail.model.Cocktails;
import com.example.cocktail.service.CocktailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class CocktailController {
    private CocktailService cocktailService;

    @GetMapping("/")
    public List<Cocktails> getCocktails(){
        return cocktailService.getAll();
    }
    @GetMapping("/cocktails/{cocktailId}")
    public Cocktails getCocktailById (@PathVariable Integer cocktailId){
        return cocktailService.getById(cocktailId);
    }
    @PostMapping("/cocktails")
    public List<Cocktails> addNewCategory (@RequestBody List<Cocktails> cocktail){
        return cocktailService.saveAll(cocktail);
    }
}
