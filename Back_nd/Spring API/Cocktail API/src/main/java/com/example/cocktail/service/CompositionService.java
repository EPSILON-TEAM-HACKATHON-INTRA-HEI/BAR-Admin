package com.example.cocktail.service;

import com.example.cocktail.model.Compositions;
import com.example.cocktail.repository.CompositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class CompositionService {
    private final CompositionRepository compositionRepository;

    public List<Compositions> getAll(){
        return compositionRepository.findAll();
    }
    public Compositions getById(Integer composition_id){
        return compositionRepository.getReferenceById(composition_id);
    }
    @Transactional
    public List<Compositions> saveAll(List<Compositions> composition){
        return compositionRepository.saveAll(composition);
    }
}
