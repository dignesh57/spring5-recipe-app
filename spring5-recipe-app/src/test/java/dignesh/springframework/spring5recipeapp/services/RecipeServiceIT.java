package dignesh.springframework.spring5recipeapp.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import dignesh.springframework.spring5recipeapp.commands.RecipeCommand;
import dignesh.springframework.spring5recipeapp.converters.RecipeCommandToRecipe;
import dignesh.springframework.spring5recipeapp.converters.RecipeToRecipeCommand;
import dignesh.springframework.spring5recipeapp.domain.Recipe;
import dignesh.springframework.spring5recipeapp.repositories.RecipeRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RecipeServiceIT {

	public static final String NEW_DESCRIPTION="New Description";
	
	@Autowired
	RecipeService recipeService;

	@Autowired
	RecipeRepository recipeRepository;

	@Autowired
	RecipeCommandToRecipe recipeCommandToRecipe;

	@Autowired
	RecipeToRecipeCommand recipeToRecipeCommand;

	@Test
	@Transactional
	void testSaveOfDescription() {
		
		Iterable<Recipe> recipes=recipeRepository.findAll();
		Recipe recipe=recipes.iterator().next();
		RecipeCommand testRecipeCommand=recipeToRecipeCommand.convert(recipe);
		
		testRecipeCommand.setDescription(NEW_DESCRIPTION);
		RecipeCommand savedRecipeCommand=recipeService.saveRecipeCommand(testRecipeCommand);
		
		assertEquals(NEW_DESCRIPTION, savedRecipeCommand.getDescription());
		assertEquals(recipe.getId(), savedRecipeCommand.getId());
		assertEquals(recipe.getCategories().size(), savedRecipeCommand.getCategories().size());
		assertEquals(recipe.getIngredients().size(), savedRecipeCommand.getIngredients().size());
	}

}
