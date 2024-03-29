package dignesh.springframework.spring5recipeapp.services;

import dignesh.springframework.spring5recipeapp.commands.IngredientCommand;

public interface IngredientService{
	
	IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
	
	IngredientCommand saveIngredientCommand(IngredientCommand command);
	
	void deleteById(Long recipeId, Long idToDelete);
}
