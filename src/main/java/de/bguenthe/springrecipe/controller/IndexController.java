package de.bguenthe.springrecipe.controller;

import de.bguenthe.springrecipe.domain.Category;
import de.bguenthe.springrecipe.domain.UnitOfMeasure;
import de.bguenthe.springrecipe.repositories.CategoryRepository;
import de.bguenthe.springrecipe.repositories.UnitOfMeasureRepository;
import de.bguenthe.springrecipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Slf4j
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeService recipeService;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        log.debug("getIndexCalled");
        model.addAttribute("recipes", recipeService.getAllRecipies());

        return "index";
    }
}
