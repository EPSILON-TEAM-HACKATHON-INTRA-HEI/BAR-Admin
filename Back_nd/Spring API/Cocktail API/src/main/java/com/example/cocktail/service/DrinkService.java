package com.example.cocktail.service;

import com.example.cocktail.model.Drinks;
import com.example.cocktail.repository.DrinkRepository;
import lombok.AllArgsConstructor;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

//import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DrinkService {
    private final DrinkRepository drinksRepository;

    public Drinks save(Drinks drinks){
        return drinksRepository.save(drinks);
    }
    public List<Drinks> getAll(){
        return drinksRepository.findAll();
    }
    public Drinks getById(Integer drink_id){
        return drinksRepository.getReferenceById(drink_id);
    }


    public Drinks updatePrice(Integer id, Long new_price){
        Optional<Drinks> drinks = drinksRepository.findById(id);
        if(drinks.isPresent()){
            Drinks drinks1 = drinks.get();
            drinks1.setPrice(new_price);
            return drinksRepository.save(drinks1);
        }else {
            throw new NullPointerException("Drinks is id not found");
        }
    }
    public String deleteById(Integer id){
        drinksRepository.deleteById(id);
        return "Resource deleted successfully";
    }

}
