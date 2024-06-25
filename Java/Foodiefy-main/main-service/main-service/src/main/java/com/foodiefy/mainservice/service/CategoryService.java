package com.foodiefy.mainservice.service;

import com.foodiefy.mainservice.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    //crud operations -> create, read, update, delete

    List<CategoryDto> getAllCategories();

    CategoryDto getCategoryById(long id);

    String addCategory(CategoryDto categoryDto);

    String updateCategory(CategoryDto categoryDto, long id);

    String deleteCategory(long id);
}
