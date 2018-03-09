package de.bguenthe.springrecipe.controllers;

import de.bguenthe.springrecipe.services.ImageService;
import de.bguenthe.springrecipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
public class ImageController {
    private final ImageService imageService;
    private final RecipeService recipeService;

    public ImageController(ImageService imageService, RecipeService recipeService) {
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("recipe/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/imageuploadform";
    }

    @PostMapping ("recipe/{id}/image")
    public String image(@PathVariable String id, @RequestParam("imagefile") MultipartFile file) {
        imageService.saveImageFile(new Long(id).longValue(), file);

        return "redirect:/recipe/" + new Long(id).longValue() + "/show";
    }
}
