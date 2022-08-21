package com.example.cocktail.repository;

import com.example.cocktail.model.Drinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drinks,Integer> {
    List<Drinks> findByCategoryId(Integer category_id);
}