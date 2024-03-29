package dignesh.springframework.spring5recipeapp.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import dignesh.springframework.spring5recipeapp.domain.Recipe;
import dignesh.springframework.spring5recipeapp.services.RecipeService;

class IndexControllerTest {

	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	IndexController controller;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		controller = new IndexController(recipeService);
	}

	@Test
	void mockMvcTest() throws Exception {
		
		MockMvc mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
		
		mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
		
	}
	
	@Test
	void testGetIndexPage() {
		
		//given
		Set<Recipe> recipes=new HashSet<Recipe>();
		recipes.add(new Recipe());
		
		Recipe recipe=new Recipe();
		recipe.setId(1L);
		
		recipes.add(recipe);
		
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		
		when(recipeService.getRecipes()).thenReturn(recipes);
		
		//when
		String viewName=controller.getIndexPage(model);
		
		//then
		assertEquals("index", viewName);
		verify(recipeService,times(1)).getRecipes();
		verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
	}

}
