package com.example.cocktail.service;

import com.example.cocktail.model.Categories;
import com.example.cocktail.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Categories> getAll(){
        return categoryRepository.findAll();
    }
    public Categories getById(Integer category_id){
        return categoryRepository.getReferenceById(category_id);
    }
    @Transactional
    public List<Categories> saveAll(List<Categories> category){
        return categoryRepository.saveAll(category);
    }
}
