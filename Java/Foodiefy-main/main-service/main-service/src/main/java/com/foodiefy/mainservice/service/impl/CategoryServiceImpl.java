package com.foodiefy.mainservice.service.impl;

import com.foodiefy.mainservice.dto.CategoryDto;
import com.foodiefy.mainservice.dto.RecipeDto;
import com.foodiefy.mainservice.model.Category;
import com.foodiefy.mainservice.model.Recipe;
import com.foodiefy.mainservice.repository.CategoryRepository;
import com.foodiefy.mainservice.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }



    //this method returns all the categories
    /**
     * Retrieves a list of all categories along with their associated recipes
     * and transforms them into a list of CategoryDto objects.
     *
     * @return List<CategoryDto> - A list of CategoryDto objects representing categories
     *         and their associated recipes.
     */
    @Override
    public List<CategoryDto> getAllCategories() {
        // Retrieve all categories from the repository
        List<Category> categories = categoryRepository.findAll();

        // Initialize lists to store CategoryDto and RecipeDto objects
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<RecipeDto> recipeDtos = new ArrayList<>();

        // Iterate through each Category entity
        categories.forEach(category -> {
            // Create a CategoryDto object and populate it with category information
            CategoryDto categoryDto = CategoryDto.builder()
                    .description(category.getDescription())
                    .name(category.getCategoryName())
                    .build();

            // Iterate through each Recipe associated with the current category
            category.getRecipes().forEach(recipe -> {
                // Map each Recipe entity to a RecipeDto and add it to the list
                recipeDtos.add(mapToRecipeDto(recipe));
            });

            // Set the list of RecipeDtos for the current category
            categoryDto.setRecipes(recipeDtos);

            // Add the CategoryDto to the final list
            categoryDtos.add(categoryDto);
        });

        // Return the list of CategoryDto objects containing category and recipe information
        return categoryDtos;
    }


    /**
     * Retrieves a specific category by its unique identifier and transforms it into a CategoryDto.
     *
     * @param id long - The unique identifier of the category to be retrieved.
     * @return CategoryDto - A CategoryDto object representing the category and its associated recipes.
     * @throws RuntimeException if the category with the specified id is not found.
     */
    @Override
    public CategoryDto getCategoryById(long id) {
        // Retrieve the category from the repository by its unique identifier
        Category category = categoryRepository.findById(id).orElse(null);

        // Check if the category is not found, and throw an exception if necessary
        if (category == null) {
            throw new RuntimeException("Category not found with id: " + id);
        }

        // Initialize a list to store RecipeDto objects
        List<RecipeDto> recipeDtos = new ArrayList<>();

        // Iterate through each Recipe associated with the retrieved category
        category.getRecipes().forEach(recipe -> {
            // Map each Recipe entity to a RecipeDto and add it to the list
            recipeDtos.add(mapToRecipeDto(recipe));
        });

        // Build and return a CategoryDto object with category and recipe information
        return CategoryDto.builder()
                .description(category.getDescription())
                .name(category.getCategoryName())
                .recipes(recipeDtos)
                .build();
    }


    /**
     * Adds a new category based on the provided CategoryDto.
     *
     * @param categoryDto CategoryDto - The CategoryDto containing information for the new category.
     * @return String - A message indicating the success of the category addition.
     */
    @Override
    public String addCategory(CategoryDto categoryDto) {
        // Create a new Category entity
        Category category = new Category();

        // Set the category name and description from the provided CategoryDto
        category.setCategoryName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        // Save the new category to the repository
        categoryRepository.save(category);

        // Return a success message
        return "Category added successfully";
    }


    /**
     * Updates an existing category based on the provided CategoryDto and category identifier.
     *
     * @param categoryDto CategoryDto - The CategoryDto containing updated information for the category.
     * @param id long - The unique identifier of the category to be updated.
     * @return String - A message indicating the success of the category update.
     * @throws RuntimeException if the category with the specified id is not found.
     */
    @Override
    public String updateCategory(CategoryDto categoryDto, long id) {
        // Retrieve the existing category from the repository by its unique identifier
        Category category = categoryRepository.findById(id).orElse(null);

        // Check if the category is not found, and throw an exception if necessary
        if (category == null) {
            throw new RuntimeException("Category not found with id: " + id);
        }

        // Update the category name and description based on the provided CategoryDto
        category.setCategoryName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        // Save the updated category to the repository
        categoryRepository.save(category);

        // Return a success message
        return "Category updated successfully";
    }


    /**
     * Deletes a category based on its unique identifier.
     *
     * @param id long - The unique identifier of the category to be deleted.
     * @return String - A message indicating the success of the category deletion.
     * @Transactional - Ensures that the operation is atomic and transactional.
     */
    @Override
    @Transactional
    public String deleteCategory(long id) {
        // Delete the category from the repository by its unique identifier
        categoryRepository.deleteById(id);

        // Return a success message
        return "Category deleted successfully";
    }


    /**
     * Maps a RecipeDto object to a Recipe entity.
     *
     * @param recipeDto RecipeDto - The RecipeDto to be mapped to a Recipe entity.
     * @return Recipe - The Recipe entity with information from the provided RecipeDto.
     */
    private Recipe mapRecipeDtoToRecipe(RecipeDto recipeDto) {
        // Create a new Recipe entity
        Recipe recipe = new Recipe();

        // Set attributes of the Recipe entity based on the provided RecipeDto
        recipe.setDescription(recipeDto.getDescription());
        recipe.setName(recipeDto.getName());
        recipe.setIngredients(recipeDto.getIngredients());
        recipe.setInstruction(recipeDto.getInstructions());
        recipe.setServings(recipeDto.getServings());
        recipe.setVideoUrl(recipeDto.getVideoUrl());
        recipe.setImageUrl(recipeDto.getImageUrl());

        // Return the mapped Recipe entity
        return recipe;
    }

    /**
     * Maps a Recipe entity to a RecipeDto object.
     *
     * @param recipe Recipe - The Recipe entity to be mapped to a RecipeDto.
     * @return RecipeDto - The RecipeDto with information from the provided Recipe entity.
     */
    private RecipeDto mapToRecipeDto(Recipe recipe) {
        // Build and return a RecipeDto object with information from the provided Recipe entity
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
