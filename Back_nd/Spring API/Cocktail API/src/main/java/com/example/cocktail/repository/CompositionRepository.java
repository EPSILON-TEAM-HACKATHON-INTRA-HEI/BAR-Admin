package com.example.cocktail.repository;

import com.example.cocktail.model.Compositions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositionRepository extends JpaRepository<Compositions, Integer> {
}
