package com.example.api;

import java.util.List;

public class RecipesResponse {

    private List<Recipe> recipes;

    public RecipesResponse(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
