package com.foodiefy.mainservice.controller;


import com.foodiefy.mainservice.dto.RecipeDto;
import com.foodiefy.mainservice.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RecipeDto>> getAllRecipes(){
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable long id){
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<String> addRecipe(@RequestBody RecipeDto recipeDto){
        return ResponseEntity.ok(recipeService.addRecipe(recipeDto));
    }

    @PutMapping("/updated/{id}")
    public ResponseEntity<String> update(@RequestBody RecipeDto recipeDto, @PathVariable long id){
        return ResponseEntity.ok(recipeService.updateRecipe(recipeDto,id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        return ResponseEntity.ok(recipeService.deleteRecipe(id));
    }


}
