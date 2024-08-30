package ru.janeryshouse.invasion_planner.factories;

import ru.janeryshouse.invasion_planner.model.Target;

import java.util.UUID;

public class TargetFactory {

    public Target create(UUID id) {
        Target target = new Target();
        target.setId(id);
        return target;
    }
}
