package dignesh.springframework.spring5recipeapp.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import dignesh.springframework.spring5recipeapp.domain.Category;
import dignesh.springframework.spring5recipeapp.domain.Difficulty;
import dignesh.springframework.spring5recipeapp.domain.Ingredient;
import dignesh.springframework.spring5recipeapp.domain.Notes;
import dignesh.springframework.spring5recipeapp.domain.Recipe;
import dignesh.springframework.spring5recipeapp.domain.UnitOfMeasure;
import dignesh.springframework.spring5recipeapp.repositories.CategoryRepository;
import dignesh.springframework.spring5recipeapp.repositories.RecipeRepository;
import dignesh.springframework.spring5recipeapp.repositories.UnitOfMeasureRepository;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	
	public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
			UnitOfMeasureRepository unitOfMeasureRepository) {
		
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}
	
	private List<Recipe> getRecipes(){
		
		List<Recipe> recipes=new ArrayList<Recipe>();
		
		Optional<UnitOfMeasure> eachUomOptional=unitOfMeasureRepository.findByDescription("Each");
		if(!eachUomOptional.isPresent()) {
			throw new RuntimeException("Expected uom not found");
		}
		
		Optional<UnitOfMeasure> tableSpoonUomOptional=unitOfMeasureRepository.findByDescription("TableSpoon");
		if(!tableSpoonUomOptional.isPresent()) {
			throw new RuntimeException("Expected uom not found");
		}
		
		Optional<UnitOfMeasure> teaSpoonUomOptional=unitOfMeasureRepository.findByDescription("TeaSpoon");
		if(!teaSpoonUomOptional.isPresent()) {
			throw new RuntimeException("Expected uom not found");
		}
		
		Optional<UnitOfMeasure> dashUomOptional=unitOfMeasureRepository.findByDescription("Dash");
		if(!dashUomOptional.isPresent()) {
			throw new RuntimeException("Expected uom not found");
		}
		
		Optional<UnitOfMeasure> pintUomOptional=unitOfMeasureRepository.findByDescription("Pint");
		if(!pintUomOptional.isPresent()) {
			throw new RuntimeException("Expected uom not found");
		}
		
		
		Optional<UnitOfMeasure> cupsUomOptional=unitOfMeasureRepository.findByDescription("Cup");
		if(!cupsUomOptional.isPresent()) {
			throw new RuntimeException("Expected uom not found");
		}
		
		UnitOfMeasure eachuom=eachUomOptional.get();
		UnitOfMeasure tablespoonuom=tableSpoonUomOptional.get();
		UnitOfMeasure teaspoonuom=teaSpoonUomOptional.get();
		UnitOfMeasure pintuom=pintUomOptional.get();
		UnitOfMeasure cupuom=cupsUomOptional.get();
		UnitOfMeasure dashuom=dashUomOptional.get();
		
		Optional<Category> americanCategoryOptional=categoryRepository.findByDescription("American");
		if(!americanCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected category not found");
			
		}
		
		Optional<Category> maxicanCategoryOptional=categoryRepository.findByDescription("Maxican");
		if(!maxicanCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected category not found");
			
		}
		
		Category americanCategory=americanCategoryOptional.get();
		Category maxicanCategory=maxicanCategoryOptional.get();
		
		Recipe guacRecipe=new Recipe();
		guacRecipe.setDecription("Perfect Guacamole");
		guacRecipe.setPrepTime(10);
		guacRecipe.setCookTime(0);
		guacRecipe.setDifficulty(Difficulty.EASY);
		guacRecipe.setDirection("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\r\n" + 
				"\r\n" + 
				"Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\r\n" + 
				"\r\n" + 
				"Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\r\n" + 
				"\r\n" + 
				"Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\r\n" + 
				"\r\n" + 
				"4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");
		
		Notes guacNotes=new Notes();
		guacNotes.setRecipeNotes("Put the onion, chiles, cilantro, and salt into a molcajete (see note above) and crush to a paste. Cut the avocados in half and, without peeling, remove the pit and squeeze out the flesh. Mash the avocado roughly into the base and mix well. Stir in the tomatoes and sprinkle the surface of the guacamole with the toppings. Serve immediately.");
		
		guacRecipe.setNotes(guacNotes);
		
		guacRecipe.addIngredient(new Ingredient("ripe avocados",new BigDecimal(2),eachuom));
		guacRecipe.addIngredient(new Ingredient("koser salt",new BigDecimal(".5"),teaspoonuom));
		guacRecipe.addIngredient(new Ingredient("resh lime juice or lemon juice",new BigDecimal(2),tablespoonuom));
		guacRecipe.addIngredient(new Ingredient("minced red onion or thinly sliced green onion",new BigDecimal(2),tablespoonuom));
		guacRecipe.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced",new BigDecimal(2),eachuom));
		guacRecipe.addIngredient(new Ingredient("cilantro (leaves and tender stems), finely chopped",new BigDecimal(2),tablespoonuom));
		guacRecipe.addIngredient(new Ingredient(" freshly grated black pepper",new BigDecimal(2),dashuom));
		guacRecipe.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped",new BigDecimal(".5"),eachuom));
		
		guacRecipe.getCategories().add(americanCategory);
		guacRecipe.getCategories().add(maxicanCategory);
		
		recipes.add(guacRecipe);
		
		return recipes;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		recipeRepository.saveAll(getRecipes());
	}
	
}
