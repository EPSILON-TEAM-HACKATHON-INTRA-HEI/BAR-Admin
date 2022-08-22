package com.example.cocktail.service;

import com.example.cocktail.model.Compositions;
import com.example.cocktail.model.Drinks;
import com.example.cocktail.repository.CompositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompositionService {
    private final CompositionRepository compositionRepository;

    public Compositions save(Compositions composition){
        return compositionRepository.save(composition);
    }
    public List<Compositions> getAll(){
        return compositionRepository.findAll();
    }
    public Compositions getById(Integer composition_id){
        return compositionRepository.getReferenceById(composition_id);
    }
    public String deleteById(Integer id){
        compositionRepository.deleteById(id);
        return "Resource deleted successfully";
    }
}
