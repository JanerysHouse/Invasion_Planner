package ru.janeryshouse.invasion_planner.factories;

import ru.janeryshouse.invasion_planner.model.Resource;

import java.util.UUID;

public class ResourceFactory {

    public static Resource create(UUID id) {
        Resource resource = new Resource();
        resource.setId(id);
        return resource;
    }
}
