package de.bguenthe.springrecipe.services;

import de.bguenthe.springrecipe.domain.Recipe;
import de.bguenthe.springrecipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceTest {

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeService(recipeRepository);
    }

    @Test
    public void getAllRecipies() {
        Recipe recipe = new Recipe();
        HashSet hashSet = new HashSet();
        hashSet.add(recipe);

        when(recipeService.getAllRecipies()).thenReturn(hashSet);

        Set<Recipe> recipes = recipeService.getAllRecipies();

        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }
}