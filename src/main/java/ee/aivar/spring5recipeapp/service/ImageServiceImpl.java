package ee.aivar.spring5recipeapp.service;

import ee.aivar.spring5recipeapp.domain.Recipe;
import ee.aivar.spring5recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {
        log.debug("Saving file of recipe with id: {}", recipeId);

        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();

            Byte[] bytes = new Byte[file.getBytes().length];

            int i = 0;
            for (byte b : file.getBytes()) {
                bytes[i++] = b;
            }

            recipe.setImage(bytes);

            recipeRepository.save(recipe);
        } catch (IOException ex) {
            log.error("Error during image save", ex);

            ex.printStackTrace();
        }
    }
}
