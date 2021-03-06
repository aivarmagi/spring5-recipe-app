package ee.aivar.spring5recipeapp.converter;

import ee.aivar.spring5recipeapp.command.NotesCommand;
import ee.aivar.spring5recipeapp.domain.Notes;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source) {

        if (source == null) {
            return null;
        }

        log.debug("Converting NotesCommand to Notes with id:{}", source.getId());
        final Notes notes = new Notes();

        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());

        return notes;
    }
}
