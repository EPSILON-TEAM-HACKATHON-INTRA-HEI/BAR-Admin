package com.example.cocktail.repository;

import com.example.cocktail.model.Compositions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompositionRepository extends JpaRepository<Compositions, Integer> {
   /** @Query(nativeQuery = true,value = "select COUNT(drinks) from Compositions join Cocktails " +
            "on Cocktails.id=drinks group by count(Compositions.drinks) ")
    List<Compositions> countList();*/
}
