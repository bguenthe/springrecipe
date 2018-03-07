package de.bguenthe.springrecipe.services;

import de.bguenthe.springrecipe.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
