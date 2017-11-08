package ee.aivar.spring5recipeapp.controllers;

import ee.aivar.spring5recipeapp.service.IngredientService;
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
    private final IngredientService ingredientService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/recipe/{id}/ingredients")
    public String getListOfIngredients(@PathVariable String id, Model model) {
        log.debug("Getting ingredient list for recipe id: {}", id);

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/ingredient/list";
    }

    @GetMapping("recipe/{recipeId}/ingredient/{ingredientId}/show")
    public String showIngredient(@PathVariable String recipeId,
                                 @PathVariable String ingredientId,
                                 Model model)
    {
        log.debug("Getting ingredient list for recipe id: {} and ingredient id: {}", recipeId, ingredientId);

        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(ingredientId)));

        return "recipe/ingredient/show";
    }
}
