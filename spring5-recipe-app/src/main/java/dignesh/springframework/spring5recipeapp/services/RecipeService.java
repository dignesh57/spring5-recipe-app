package dignesh.springframework.spring5recipeapp.services;

import java.util.Set;

import dignesh.springframework.spring5recipeapp.commands.RecipeCommand;
import dignesh.springframework.spring5recipeapp.domain.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();
	
	Recipe findById(Long l);
	
	RecipeCommand saveRecipeCommand(RecipeCommand command);

	RecipeCommand findCommandById(Long id);
	
	void deleteById(Long idToDelete);
}
