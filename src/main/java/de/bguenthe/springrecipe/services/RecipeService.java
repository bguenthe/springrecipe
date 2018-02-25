package de.bguenthe.springrecipe.services;

import de.bguenthe.springrecipe.commands.RecipeCommand;
import de.bguenthe.springrecipe.domain.Recipe;

import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
