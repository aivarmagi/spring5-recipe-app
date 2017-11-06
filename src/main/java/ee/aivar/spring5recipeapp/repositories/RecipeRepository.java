package ee.aivar.spring5recipeapp.repositories;

import ee.aivar.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
