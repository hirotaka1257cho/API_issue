package com.example.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    @Autowired
    private RecipeRepository repository;

    @GetMapping("/recipes")
    public RecipesResponse getRecipes() {
        return new RecipesResponse(repository.findAll());
    }

    @PostMapping("/recipes")
    public RecipeResponse create(@RequestBody Recipe recipe) {
        Recipe saved = repository.save(recipe);

        return new RecipeResponse(
                "Recipe successfully created!",
                List.of(saved));
    }

    @GetMapping("/recipes/{id}")
    public RecipeResponse getOne(@PathVariable Long id) {
        Optional<Recipe> recipe = repository.findById(id);

        if (recipe.isPresent()) {
            return new RecipeResponse(
                    "Recipe details by id",
                    List.of(recipe.get()));
        }

        return new RecipeResponse(
                "No Recipe found",
                null);
    }

    @PatchMapping("/recipes/{id}")
    public RecipeResponse update(@PathVariable Long id, @RequestBody Recipe recipe) {
        if (!repository.existsById(id)) {
            return new RecipeResponse(
                    "No Recipe found",
                    null);
        }

        recipe.setId(id);
        Recipe updated = repository.save(recipe);

        return new RecipeResponse(
                "Recipe successfully updated!",
                List.of(updated));
    }

    @DeleteMapping("/recipes/{id}")
    public MessageResponse delete(@PathVariable Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new MessageResponse("Recipe successfully removed!");
        } else {
            return new MessageResponse("No Recipe found");
        }
    }
}
