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

    @GetMapping("/compositions")
    public List<Compositions> getAll(){
        return compositionService.getAll();
    }
    @GetMapping("/compositions/{compositionId}")
    public Compositions getCompositionById(@PathVariable Integer compositionId){
        return compositionService.getById(compositionId);
    }
    @PostMapping("/compositions")
    public List<Compositions> saveAll(@RequestBody  List<Compositions> composition){
        return compositionService.saveAll(composition);
    }

}
