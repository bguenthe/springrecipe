package de.bguenthe.springrecipe.controller;

import de.bguenthe.springrecipe.domain.Recipe;
import de.bguenthe.springrecipe.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        indexController = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {
        //given
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(new Recipe());

        Recipe r = new Recipe();
        r.setId(1L);
        recipeSet.add(r);

        when(recipeService.getAllRecipies()).thenReturn(recipeSet);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        assertEquals("index", indexController.getIndexPage(model));
        verify(recipeService, times(1)).getAllRecipies();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());

        Set<Recipe> recipeSet1 = argumentCaptor.getValue();
        assertEquals(2, recipeSet1.size());
    }
}