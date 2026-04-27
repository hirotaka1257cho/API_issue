package com.example.api;

import java.util.List;

public class RecipeResponse {

    private String message;
    private List<Recipe> recipe;

    public RecipeResponse(String message, List<Recipe> recipe) {
        this.message = message;
        this.recipe = recipe;
    }

    public String getMessage() {
        return message;
    }

    public List<Recipe> getRecipe() {
        return recipe;
    }
}
