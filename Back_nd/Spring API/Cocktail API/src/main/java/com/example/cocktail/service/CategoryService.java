package com.example.cocktail.service;

import com.example.cocktail.model.Categories;
import com.example.cocktail.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Categories save(Categories category){
        return categoryRepository.save(category);
    }
    public List<Categories> getAll(){
        return categoryRepository.findAll();
    }
    public Categories getById(Integer category_id){
        return categoryRepository.getReferenceById(category_id);
    }

    public String deleteById(Integer id){
        categoryRepository.deleteById(id);
        return "Resource deleted successfully";
    }
}
