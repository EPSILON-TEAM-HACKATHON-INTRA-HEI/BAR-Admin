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

    @PostMapping("/categories")
    public Categories AddNewCategory (@RequestBody Categories category){
        return categoryService.save(category);
    }
    @GetMapping("/categories")
    public List<Categories> getCategories(){
       return categoryService.getAll();
    }
    @GetMapping("/categories/{categoryId}")
    public Categories getCategoryById (@PathVariable Integer categoryId){
        return categoryService.getById(categoryId);
    }
    @DeleteMapping("/categories/{id}")
    public String deleteCategoryById(@PathVariable Integer id){
        return categoryService.deleteById(id);
    }

}
