package com.example.recipes.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;
import com.example.recipes.entity.Recipe;
import com.example.recipes.service.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @PostMapping
    public Recipe create(@RequestBody Recipe recipe) {
        return service.createRecipe(recipe);
    }
    
    
    @GetMapping("/top")
    public Map<String, List<Recipe>> getTopRecipes(
            @RequestParam(defaultValue = "5") int limit) {

        List<Recipe> recipes = service.getTopRecipes(limit);

        Map<String, List<Recipe>> response = new HashMap<>();
        response.put("data", recipes);

        return response;
    }
    
    
}