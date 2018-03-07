package de.bguenthe.springrecipe.services;

import de.bguenthe.springrecipe.commands.IngredientCommand;
import de.bguenthe.springrecipe.commands.RecipeCommand;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jt on 6/27/17.
 */
public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    @Transactional
    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(Long id);
}