package dignesh.springframework.spring5recipeapp.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import dignesh.springframework.spring5recipeapp.domain.Recipe;
import dignesh.springframework.spring5recipeapp.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	private final RecipeRepository recipeRepository;
	
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}


	@Override
	public Set<Recipe> getRecipes() {
		Set<Recipe> recipes=new HashSet<Recipe>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		return recipes;
	}

}
