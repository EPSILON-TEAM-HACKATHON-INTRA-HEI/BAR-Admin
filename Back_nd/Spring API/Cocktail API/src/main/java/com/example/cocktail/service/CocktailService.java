package com.example.cocktail.service;

import com.example.cocktail.model.Cocktails;
import com.example.cocktail.repository.CocktailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CocktailService {
    private final CocktailRepository cocktailRepository;

    public Cocktails save(Cocktails cocktail){
        return cocktailRepository.save(cocktail);
    }
    public List<Cocktails> getAll(){
        return cocktailRepository.findAll();
    }
   /**
    * public List<Object> info(){
        return cocktailRepository.ShowCocktailInfo();
    }**/
    public Cocktails getById(Integer cocktail_id){
        return cocktailRepository.getReferenceById(cocktail_id);
    }

    public Cocktails updateName(Integer id, String newName){
        Optional<Cocktails> cocktails = cocktailRepository.findById(id);
        if(cocktails.isPresent()){
            Cocktails cocktails1 = cocktails.get();
            cocktails1.setName(newName);
            return cocktailRepository.save(cocktails1);
        }else {
            throw new NullPointerException("Cocktails is id not found");
        }
    }
    public String deleteById(Integer id){
        cocktailRepository.deleteById(id);
        return "Resource deleted successfully";
    }
}
