package dignesh.springframework.spring5recipeapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dignesh.springframework.spring5recipeapp.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{
	
	Optional<UnitOfMeasure> findByDescription(String decription);
}
