package repositories;

import de.bguenthe.springrecipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface  RecipeRepository extends CrudRepository<Recipe, Long> {
}
