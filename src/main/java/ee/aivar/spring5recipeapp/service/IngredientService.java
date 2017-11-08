package ee.aivar.spring5recipeapp.service;

import ee.aivar.spring5recipeapp.command.IngredientCommand;
import org.springframework.stereotype.Service;

@Service
public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
