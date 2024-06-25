package com.foodiefy.mainservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeDto {

    private String name;
    private String description;
    private String instructions;
    private String ingredients;
    private String imageUrl;
    private String videoUrl;
    private short servings;
    private long userId;
    private List<Integer> menuIds;
    private long categoryId;
}
