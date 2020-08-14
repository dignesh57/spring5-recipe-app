package dignesh.springframework.spring5recipeapp.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dignesh.springframework.spring5recipeapp.domain.UnitOfMeasure;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testFindByDescription() {
		
		Optional<UnitOfMeasure> uomOptional=unitOfMeasureRepository.findByDescription("TeaSpoon");
		
		assertEquals("TeaSpoon", uomOptional.get().getDescription());
		
	}

}
