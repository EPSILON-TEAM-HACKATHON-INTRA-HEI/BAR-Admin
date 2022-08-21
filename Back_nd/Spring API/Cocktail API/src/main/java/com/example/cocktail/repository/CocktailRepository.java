package com.example.cocktail.repository;

import com.example.cocktail.model.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CocktailRepository extends JpaRepository<Cocktail,Integer> {
}