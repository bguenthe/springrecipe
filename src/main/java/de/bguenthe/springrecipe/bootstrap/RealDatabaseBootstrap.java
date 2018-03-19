package de.bguenthe.springrecipe.bootstrap;


import de.bguenthe.springrecipe.domain.Category;
import de.bguenthe.springrecipe.domain.UnitOfMeasure;
import de.bguenthe.springrecipe.repositories.CategoryRepository;
import de.bguenthe.springrecipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"uat", "prod", "prodaws"})
public class RealDatabaseBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RealDatabaseBootstrap(CategoryRepository categoryRepository,
                          UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if (categoryRepository.count() == 0L){
            log.debug("Loading Categories");
            loadCategories();
        }

        if (unitOfMeasureRepository.count() == 0L){
            log.debug("Loading UOMs");
            loadUom();
        }
    }

    private void loadCategories(){
        Category cat1 = new Category();
        cat1.setCategoryName("Mexikanisch");
        categoryRepository.save(cat1);

        Category cat2 = new Category();
        cat2.setCategoryName("Asiatisch");
        categoryRepository.save(cat2);

        Category cat3 = new Category();
        cat3.setCategoryName("Griechisch");
        categoryRepository.save(cat3);

        Category cat4 = new Category();
        cat4.setCategoryName("Deutsch");
        categoryRepository.save(cat4);
    }

    private void loadUom(){
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setDescription("Teelöffel");
        unitOfMeasureRepository.save(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setDescription("Tasse");
        unitOfMeasureRepository.save(uom2);

        UnitOfMeasure uom3 = new UnitOfMeasure();
        uom3.setDescription("Milliliter");
        unitOfMeasureRepository.save(uom3);
    }
}
