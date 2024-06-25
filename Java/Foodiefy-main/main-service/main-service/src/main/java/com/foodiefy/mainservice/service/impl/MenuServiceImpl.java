package com.foodiefy.mainservice.service.impl;

import com.foodiefy.mainservice.dto.MenuDto;
import com.foodiefy.mainservice.dto.RecipeDto;
import com.foodiefy.mainservice.model.Menu;
import com.foodiefy.mainservice.model.Recipe;
import com.foodiefy.mainservice.repository.MenuRepository;
import com.foodiefy.mainservice.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<MenuDto> getAllMenus() {
        List<Menu> menus = menuRepository.findAll();

        List<MenuDto> menuDtos = new ArrayList<>();
        List<RecipeDto> recipeDtos = new ArrayList<>();

        menus.forEach(menu -> {

            MenuDto menuDto = MenuDto.builder()
                    .description(menu.getDescription())
                    .name(menu.getName())
                    .build();

            menu.getRecipes().forEach(recipe -> {
                recipeDtos.add(mapToRecipeDto(recipe));
            });

            menuDto.setRecipes(recipeDtos);

            menuDtos.add(menuDto);
        });

        return menuDtos;
    }

    @Override
    public MenuDto getMenuById(long id) {

        Menu menu = menuRepository.findById(id).orElse(null);

        if (menu == null){
            throw new RuntimeException("Menu not found with id: " + id);
        }

        List<RecipeDto> recipeDtos = new ArrayList<>();

        menu.getRecipes().forEach(recipe -> {
            recipeDtos.add(mapToRecipeDto(recipe));
        });

        return MenuDto.builder()
                .name(menu.getName())
                .description(menu.getDescription())
                .recipes(recipeDtos)
                .build();
    }

    @Override
    public String addMenu(MenuDto menuDto) {
        Menu menu = new Menu();

        menu.setName(menuDto.getName());
        menu.setDescription(menuDto.getDescription());

        menuRepository.save(menu);
        return "Menu added successfully";
    }

    @Override
    public String updateMenu(MenuDto menuDto, long id) {

        Menu menu = menuRepository.findById(id).orElse(null);

        if (menu == null) {
            throw new RuntimeException("Menu not found with id: " + id);
        }

        menu.setName(menuDto.getName());
        menu.setDescription(menuDto.getDescription());

        menuRepository.save(menu);

        return "Menu updated successfully";
    }

    @Override
    @Transactional
    public String deleteMenu(long id) {

        menuRepository.deleteById(id);

        return "Menu deleted successfully";
    }

    private Recipe mapRecipeDtoToRecipe(RecipeDto recipeDto){

        Recipe recipe = new Recipe();

        recipe.setDescription(recipeDto.getDescription());
        recipe.setName(recipeDto.getName());
        recipe.setIngredients(recipeDto.getIngredients());
        recipe.setInstruction(recipeDto.getInstructions());
        recipe.setServings(recipeDto.getServings());
        recipe.setVideoUrl(recipeDto.getVideoUrl());
        recipe.setImageUrl(recipeDto.getImageUrl());

        return recipe;
    }

    private RecipeDto mapToRecipeDto(Recipe recipe) {

        return RecipeDto.builder()
                .description(recipe.getDescription())
                .name(recipe.getName())
                .categoryId(recipe.getCategory().getId())
                .imageUrl(recipe.getImageUrl())
                .ingredients(recipe.getIngredients())
                .instructions(recipe.getInstruction())
                .servings(recipe.getServings())
                .videoUrl(recipe.getVideoUrl())
                .userId(recipe.getUser().getId())
                .build();
    }
}
