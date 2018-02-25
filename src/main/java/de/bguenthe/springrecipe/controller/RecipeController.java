package de.bguenthe.springrecipe.controller;

import de.bguenthe.springrecipe.services.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class RecipeController {
    private RecipeServiceImpl recipeService;


    public RecipeController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        log.debug("getIndexCalled");
        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }
}
