package de.bguenthe.springrecipe.services;

import de.bguenthe.springrecipe.domain.Recipe;
import de.bguenthe.springrecipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {
    RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveImageFile(Long id, MultipartFile multipartFile) {
        Recipe detachedRecipe = recipeRepository.findById(id).get();
        Byte[] image = new Byte[(int) multipartFile.getSize()];

        int i = 0;

        try {
            for (byte b : multipartFile.getBytes()) {
                image[i++] = b;
            }

            detachedRecipe.setImage(image);

            Recipe savesRecipe = recipeRepository.save(detachedRecipe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
