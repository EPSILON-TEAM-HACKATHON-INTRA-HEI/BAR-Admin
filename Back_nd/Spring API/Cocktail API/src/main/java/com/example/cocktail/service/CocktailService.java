package com.example.cocktail.service;

import com.example.cocktail.repository.CocktailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CocktailService {
    private final CocktailRepository cocktailRepository;
}
