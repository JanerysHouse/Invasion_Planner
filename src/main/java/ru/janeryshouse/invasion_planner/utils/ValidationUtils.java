package ru.janeryshouse.invasion_planner.utils;

import org.openapitools.client.model.InvasionPlanRequest;
import ru.janeryshouse.invasion_planner.model.AlienCivilization;
import ru.janeryshouse.invasion_planner.model.DefenseSystem;
import ru.janeryshouse.invasion_planner.model.Resource;
import ru.janeryshouse.invasion_planner.model.Target;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

public class ValidationUtils {

    public static void validateInvasionPlanRequest(InvasionPlanRequest request,
                                                   AlienCivilization alienCivilization,
                                                   Function<UUID, Resource> resourceFactory,
                                                   Function<UUID, Target> targetFactory,
                                                   Function<UUID, DefenseSystem> defenseSystemFactory) {
        Objects.requireNonNull(request, "request must not be null");
        Objects.requireNonNull(request.getResourceIds(), "resourceIds must not be null");
        Objects.requireNonNull(request.getTargetIds(), "targetIds must not be null");
        Objects.requireNonNull(request.getDefenseSystemIds(), "defenseSystemIds must not be null");
        Objects.requireNonNull(alienCivilization, "alienCivilization must not be null");
        Objects.requireNonNull(resourceFactory, "resourceFactory must not be null");
        Objects.requireNonNull(targetFactory, "targetFactory must not be null");
        Objects.requireNonNull(defenseSystemFactory, "defenseSystemFactory must not be null");
    }
}

