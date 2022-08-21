package com.example.cocktail.service;

import com.example.cocktail.repository.CompositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompositionService {
    private final CompositionRepository compositionRepository;
}
