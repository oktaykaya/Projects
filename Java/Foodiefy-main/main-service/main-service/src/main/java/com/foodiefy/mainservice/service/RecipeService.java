package com.foodiefy.mainservice.service;


import com.foodiefy.mainservice.dto.RecipeDto;

import java.util.List;

public interface RecipeService {
    //crud operations -> create, read, update, delete

    List<RecipeDto> getAllRecipes();

    RecipeDto getRecipeById(long id);

    String addRecipe(RecipeDto recipeDto);

    String updateRecipe(RecipeDto recipeDto, long id);

    String deleteRecipe(long id);
}
