package com.example.cocktail.controller;

import com.example.cocktail.model.Categories;
import com.example.cocktail.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Categories> getCategories(){
       return categoryService.getAll();
    }
    @GetMapping("/categories/{categoryId}")
    public Categories getCategoryById (@PathVariable Integer categoryId){
        return categoryService.getById(categoryId);
    }
    @PostMapping("/categories")
    public List<Categories> addNewCategory (@RequestBody List<Categories> category){
        return categoryService.saveAll(category);
    }
}
