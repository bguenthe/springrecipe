package de.bguenthe.springrecipe.repositories;

import de.bguenthe.springrecipe.domain.Category;
import de.bguenthe.springrecipe.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
