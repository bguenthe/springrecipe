package de.bguenthe.springrecipe.bootstrap;

import de.bguenthe.springrecipe.domain.*;
import de.bguenthe.springrecipe.repositories.CategoryRepository;
import de.bguenthe.springrecipe.repositories.RecipeRepository;
import de.bguenthe.springrecipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Component
@Profile("uat")
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
        categoryRepository.deleteAll();
        Category c = new Category();
        c.setCategoryName("Mexikanisch");
        categoryRepository.save(c);
        Category c1 = new Category();
        c1.setCategoryName("Asiatisch");
        categoryRepository.save(c1);
        Category c2 = new Category();
        c2.setCategoryName("Griechisch");
        categoryRepository.save(c2);
        Category c3 = new Category();
        c3.setCategoryName("Deutsch");
        categoryRepository.save(c3);

        unitOfMeasureRepository.deleteAll();
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription("Teelöffel");
        unitOfMeasureRepository.save(uom);

        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setDescription("Tasse");
        unitOfMeasureRepository.save(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setDescription("Milliliter");
        unitOfMeasureRepository.save(uom2);

        Recipe recipe = new Recipe();
        recipe.setDescription("Guacamole");
        recipe.setDifficulty(Difficulty.EASY);
        recipe.setPreparationTime(10);
        recipe.setCookTime(0);
        recipe.setSource("Internet");
        recipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
        recipe.setServings(99);
        recipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.");

        recipe.getCategories().add(categoryRepository.findByCategoryName("Mexikanisch").get());
        recipe.getCategories().add(categoryRepository.findByCategoryName("Asiatisch").get());

        Notes notes = new Notes();
        notes.setRecipeNotes("2 ripe avocados");
        recipe.setNotes(notes);

        Optional<UnitOfMeasure> tasseUomOptional = unitOfMeasureRepository.findByDescription("Tasse");

        Set<Ingredient> ingredients = new HashSet<>();
        Ingredient i = new Ingredient();
        i.setAmount(new BigDecimal(2));
        i.setDescription("ripe avocados");
        i.setRecipe(recipe);
        i.setUnitOfMeasure(tasseUomOptional.get());
        ingredients.add(i);

        recipe.setIngredients(ingredients);

        recipeRepository.save(recipe);

        Recipe recipe1 = new Recipe();
        recipe1.setDescription("Guacamole1");
        recipe1.setDifficulty(Difficulty.EASY);
        recipe1.setPreparationTime(10);
        recipe1.setCookTime(0);
        recipe1.setSource("Internet1");
        recipe1.setUrl("bg");
        recipe1.setServings(99);
        recipe1.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.");

        recipe1.getCategories().add(categoryRepository.findByCategoryName("Mexikanisch").get());
        recipe1.getCategories().add(categoryRepository.findByCategoryName("Asiatisch").get());

        Notes notes1 = new Notes();
        notes1.setRecipeNotes("2 ripe avocados");
        recipe1.setNotes(notes1);

        Set<Ingredient> ingredients1 = new HashSet<>();
        Ingredient i1 = new Ingredient();
        i1.setAmount(new BigDecimal(2));
        i1.setDescription("ripe avocados");
        i1.setRecipe(recipe);
        i1.setUnitOfMeasure(tasseUomOptional.get());
        ingredients1.add(i1);
        recipe1.setIngredients(ingredients1);

        recipeRepository.save(recipe1);
        log.debug("Initialisation done");

    }
}
