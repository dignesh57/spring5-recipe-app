package dignesh.springframework.spring5recipeapp.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {

	Category category;
	
	@BeforeEach
	public void setUp() {
		category=new Category();
	}
	
	@Test
	public void testGetId() throws Exception{
		long idvalue=4L;
		category.setId(idvalue);
		
		assertEquals(idvalue, category.getId());
		
	}

	@Test
	public void testGetDescription() throws Exception{
		
	}

	@Test
	public void testGetRecipes() throws Exception{
		
	}

}
