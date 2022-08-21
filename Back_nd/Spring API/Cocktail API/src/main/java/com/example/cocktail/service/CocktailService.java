package com.example.cocktail.service;

import com.example.cocktail.model.Cocktails;
import com.example.cocktail.repository.CocktailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class CocktailService {
    private final CocktailRepository cocktailRepository;

    public List<Cocktails> getAll(){
        return cocktailRepository.findAll();
    }
    public Cocktails getById(Integer cocktail_id){
        return cocktailRepository.getReferenceById(cocktail_id);
    }
    @Transactional
    public List<Cocktails> saveAll(List<Cocktails> cocktail){
        return cocktailRepository.saveAll(cocktail);
    }
}
