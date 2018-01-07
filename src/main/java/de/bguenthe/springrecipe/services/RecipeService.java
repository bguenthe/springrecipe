package de.bguenthe.springrecipe.services;

import de.bguenthe.springrecipe.domain.Recipe;
import de.bguenthe.springrecipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeService {
    RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Iterable<Recipe> getAllRecipies() {
        return recipeRepository.findAll();
    }
}
