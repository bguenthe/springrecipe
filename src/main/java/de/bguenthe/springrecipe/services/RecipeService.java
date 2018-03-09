package de.bguenthe.springrecipe.services;

import de.bguenthe.springrecipe.commands.RecipeCommand;
import de.bguenthe.springrecipe.domain.Recipe;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long aLong);
}
