package dignesh.springframework.spring5recipeapp.services;

import java.util.Set;

import dignesh.springframework.spring5recipeapp.domain.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();
}