package com.example.cocktail.controller;

import com.example.cocktail.model.Compositions;
import com.example.cocktail.service.CompositionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class CompositionController {
    private CompositionService compositionService;

    @PostMapping("/compositions")
    public Compositions AddNewComposition(@RequestBody  Compositions composition){
        return compositionService.save(composition);
    }
    @GetMapping("/compositions")
    public List<Compositions> getAll(){
        return compositionService.getAll();
    }
    @GetMapping("/compositions/{compositionId}")
    public Compositions getCompositionById(@PathVariable Integer compositionId){
        return compositionService.getById(compositionId);
    }

    @DeleteMapping("/compositions/{id}")
    public String deleteCompositionById(@PathVariable Integer id){
        return compositionService.deleteById(id);
    }

}
