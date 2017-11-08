package ee.aivar.spring5recipeapp.service;

import ee.aivar.spring5recipeapp.command.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
