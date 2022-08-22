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

    @PostMapping("/cocktails")
    public Cocktails AddNewCategory (@RequestBody Cocktails cocktail){
        return cocktailService.save(cocktail);
    }

    /**
     *
    @GetMapping("/info")
    public List<Object> info(){
      return cocktailService.info();
    }
    **/

    @GetMapping("/")
    public List<Cocktails> getCocktails(){
         return cocktailService.getAll();
    }
    @GetMapping("/cocktails/{cocktailId}")
    public Cocktails getCocktailById (@PathVariable Integer cocktailId){
        return cocktailService.getById(cocktailId);
    }

    @PatchMapping("/cocktails")
    public Cocktails updateName(
            @RequestParam(name = "id") Integer id,
            @RequestParam(name = "name") String newName)
    {
        return cocktailService.updateName(id, newName);
    }
    @DeleteMapping("/cocktails/{id}")
    public String deleteCocktailById(@PathVariable Integer id){
        return cocktailService.deleteById(id);
    }
}
