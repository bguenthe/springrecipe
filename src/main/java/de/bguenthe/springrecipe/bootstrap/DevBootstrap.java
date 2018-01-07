package de.bguenthe.springrecipe.bootstrap;

import de.bguenthe.springrecipe.domain.Difficulty;
import de.bguenthe.springrecipe.domain.Ingredient;
import de.bguenthe.springrecipe.domain.Notes;
import de.bguenthe.springrecipe.domain.Recipe;
import de.bguenthe.springrecipe.repositories.CategoryRepository;
import de.bguenthe.springrecipe.repositories.RecipeRepository;
import de.bguenthe.springrecipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DevBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Recipe recipe = new Recipe();
        recipe.setDescription("Guacamole");
        recipe.setDifficulty(Difficulty.EASY);
        recipe.setPreparationTime(10);
        recipe.setCookTime(0);
        recipe.setSource("Internet");
        recipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
        recipe.setDirections("");

        recipe.getCategories().add(categoryRepository.findByCategoryName("Mexikanisch").get());

        Notes notes = new Notes();
        notes.setRecipeNotes("2 ripe avocados");
        recipe.setNotes(notes);

        Set<Ingredient> ingredients = new HashSet<>();
        Ingredient i = new Ingredient();
        i.setAmount(new BigDecimal(2));
        i.setDescription("ripe avocados");
        i.setRecipe(recipe);
        ingredients.add(i);
        recipe.setIngredients(ingredients);

        recipeRepository.save(recipe);
        log.debug("Initialisation done");
    }
}
