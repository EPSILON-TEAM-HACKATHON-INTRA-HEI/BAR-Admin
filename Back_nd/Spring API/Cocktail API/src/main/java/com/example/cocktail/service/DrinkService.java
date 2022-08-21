package com.example.cocktail.service;

import com.example.cocktail.repository.DrinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DrinkService {
    private final DrinkRepository drinksRepository;
}
