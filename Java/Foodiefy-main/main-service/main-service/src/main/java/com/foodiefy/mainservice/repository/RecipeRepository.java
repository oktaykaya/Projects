package com.foodiefy.mainservice.repository;

import com.foodiefy.mainservice.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
}
