package ee.aivar.spring5recipeapp.service;

import ee.aivar.spring5recipeapp.command.RecipeCommand;
import ee.aivar.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long id);

    void deleteById(Long id);
}
