package dignesh.springframework.spring5recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dignesh.springframework.spring5recipeapp.services.RecipeService;

@Controller
public class IndexController {
	
	private final RecipeService recipeService;

	public IndexController(dignesh.springframework.spring5recipeapp.services.RecipeService recipeService) {
		this.recipeService = recipeService;
	}


	@RequestMapping({"","/","index.html","/index"})
	public String getIndexPage(Model model) {
		
		model.addAttribute("recipes", recipeService.getRecipes());
		
		return "index";
	}
	
}
