package ru.janeryshouse.invasion_planner.factories;

import ru.janeryshouse.invasion_planner.model.DefenseSystem;

import java.util.UUID;

public class DefenseSystemFactory {

    public DefenseSystem create(UUID id) {
        DefenseSystem defenseSystem = new DefenseSystem();
        defenseSystem.setId(id);
        return defenseSystem;
    }
}
