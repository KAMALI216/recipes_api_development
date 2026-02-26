package com.example.recipes.service;


import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.recipes.entity.Recipe;
import com.example.recipes.repository.RecipeRepository;



@Service
public class RecipeService {

    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public Recipe createRecipe(Recipe recipe) {

        if (recipe.getTitle() == null ||
            recipe.getCuisine() == null ||
            recipe.getPrepTime() == null ||
            recipe.getCookTime() == null) {
            throw new RuntimeException("Required fields missing");
        }

        recipe.setTotalTime(recipe.getPrepTime() + recipe.getCookTime());

        return repository.save(recipe);
        
    }
  
    public List<Recipe> getTopRecipes(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return repository.findAllByOrderByRatingDesc(pageable);
    }
    
    
    
    
}