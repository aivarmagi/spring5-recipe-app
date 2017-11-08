package ee.aivar.spring5recipeapp.controllers;

import ee.aivar.spring5recipeapp.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;

    public IngredientController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/ingredients")
    public String getListOfIngredients(@PathVariable String id, Model model) {
        log.debug("Getting ingredient list for recipe id: {}", id);

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/ingredient/list";
    }
}
