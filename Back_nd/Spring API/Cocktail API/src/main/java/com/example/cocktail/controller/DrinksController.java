package com.example.cocktail.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrinksController {
    @GetMapping("/")
    public String Hello (){
        return "Coucou nju!";
    }
}
