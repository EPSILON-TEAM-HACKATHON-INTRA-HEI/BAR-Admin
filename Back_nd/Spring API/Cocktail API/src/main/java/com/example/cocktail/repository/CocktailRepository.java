package com.example.cocktail.repository;

import com.example.cocktail.model.Cocktails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CocktailRepository extends JpaRepository<Cocktails,Integer> {

}