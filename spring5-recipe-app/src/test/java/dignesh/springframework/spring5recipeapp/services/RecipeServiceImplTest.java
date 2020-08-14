package dignesh.springframework.spring5recipeapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import dignesh.springframework.spring5recipeapp.domain.Recipe;
import dignesh.springframework.spring5recipeapp.repositories.RecipeRepository;

class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		recipeService = new RecipeServiceImpl(recipeRepository);
	}

	@Test
	void testGetRecipes() {
		
		Recipe recipe = new Recipe();
		HashSet<Recipe> recipesData=new HashSet<Recipe>();
		recipesData.add(recipe);
		
		Mockito.when(recipeService.getRecipes()).thenReturn(recipesData);
		
		Set<Recipe> recipes=recipeService.getRecipes();
		
		assertEquals(recipes.size(), 1);
		Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
	}

}
