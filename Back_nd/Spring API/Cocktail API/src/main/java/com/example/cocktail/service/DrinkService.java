package com.example.cocktail.service;

import com.example.cocktail.model.Drinks;
import com.example.cocktail.repository.DrinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class DrinkService {
    private final DrinkRepository drinksRepository;

    public List<Drinks> getAll(){
        return drinksRepository.findAll();
    }
    public Drinks getById(Integer drink_id){
        return drinksRepository.getReferenceById(drink_id);
    }

    public List<Drinks> findDrinksByCategoryId(Integer id){
        return drinksRepository.findByCategoryId(id);
    }
    @Transactional
    public List<Drinks> saveAll(List<Drinks> drinks){
        return drinksRepository.saveAll(drinks);
    }
}
