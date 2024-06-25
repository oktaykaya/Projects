package com.foodiefy.mainservice.service.impl;

import com.foodiefy.mainservice.dto.RecipeDto;
import com.foodiefy.mainservice.model.Category;
import com.foodiefy.mainservice.model.Menu;
import com.foodiefy.mainservice.model.Recipe;
import com.foodiefy.mainservice.model.User;
import com.foodiefy.mainservice.repository.CategoryRepository;
import com.foodiefy.mainservice.repository.MenuRepository;
import com.foodiefy.mainservice.repository.RecipeRepository;
import com.foodiefy.mainservice.repository.UserRepository;
import com.foodiefy.mainservice.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RecipeServiceImpl implements RecipeService {

    private final MenuRepository menuRepository;
    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public RecipeServiceImpl(MenuRepository menuRepository, RecipeRepository recipeRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.menuRepository = menuRepository;
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<RecipeDto> getAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();

        List<RecipeDto> recipeDtos= new ArrayList<>();

        recipes.forEach(recipe -> {
            RecipeDto recipeDto = RecipeDto.builder()
                    .name(recipe.getName())
                    .description(recipe.getDescription())
                    .ingredients(recipe.getIngredients())
                    .instructions(recipe.getInstruction())
                    .imageUrl(recipe.getImageUrl())
                    .videoUrl(recipe.getVideoUrl())
                    .servings(recipe.getServings())
                    .build();

            recipeDtos.add(recipeDto);

        });
        return recipeDtos;
    }

    @Override
    public RecipeDto getRecipeById(long id) {
        return null;
    }

    @Override
    public String addRecipe(RecipeDto recipeDto) {
        List<Menu> menus = new ArrayList<>();

        for (long id:recipeDto.getMenuIds()){
            Optional<Menu> menu = menuRepository.findById(id);
            menu.ifPresent(menus::add);
        }
        //check if the category exists
        Optional<Category> category = categoryRepository.findById(recipeDto.getCategoryId());
        if(category.isEmpty()){
            throw new RuntimeException("Category Not found with this id.");
        }
        //check if the user exists
        Optional<User> user = userRepository.findById(recipeDto.getUserId());
        if (user.isEmpty()){
            throw new RuntimeException("User Not found with this id.");
        }

        Recipe recipe = new Recipe();
        recipe.setInstruction(recipeDto.getInstructions());
        recipe.setName(recipeDto.getName());
        recipe.setDescription(recipeDto.getDescription());
        recipe.setIngredients(recipeDto.getIngredients());
        recipe.setServings(recipeDto.getServings());
        recipe.setImageUrl(recipeDto.getImageUrl());
        recipe.setCategory(category.get());
        recipe.setVideoUrl(recipeDto.getVideoUrl());
        recipe.setMenus(menus);
        recipe.setUser(user.get());
        recipeRepository.save(recipe);

        return "Recipe Created Successfully";
    }

    @Override
    public String updateRecipe(RecipeDto recipeDto, long id) {
        return null;
    }

    @Override
    public String deleteRecipe(long id) {
        return null;
    }
}
