package com.example.cocktail.repository;

import com.example.cocktail.model.Drinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DrinkRepository extends JpaRepository<Drinks,Integer> {
}