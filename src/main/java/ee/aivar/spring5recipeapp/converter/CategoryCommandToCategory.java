package ee.aivar.spring5recipeapp.converter;

import ee.aivar.spring5recipeapp.command.CategoryCommand;
import ee.aivar.spring5recipeapp.domain.Category;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {

        if (source == null) {
            return null;
        }

        log.debug("Converting CategoryCommand to Category with id:{}", source.getId());
        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());

        return category;
    }
}
