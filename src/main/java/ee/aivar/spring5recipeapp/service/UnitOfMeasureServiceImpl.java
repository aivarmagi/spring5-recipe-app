package ee.aivar.spring5recipeapp.service;

import ee.aivar.spring5recipeapp.command.UnitOfMeasureCommand;
import ee.aivar.spring5recipeapp.converter.UnitOfMeasureToUnitOfMeasureCommand;
import ee.aivar.spring5recipeapp.domain.UnitOfMeasure;
import ee.aivar.spring5recipeapp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,
                                    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand)
    {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        log.debug("Getting all UnitOfMeasureCommands");

        return StreamSupport.stream(
                    unitOfMeasureRepository
                            .findAll()
                            .spliterator(), false) //spliterator converts iterator from findAll() to java stream
                            .map(unitOfMeasureToUnitOfMeasureCommand::convert)
                            .collect(Collectors.toSet());
    }
}
