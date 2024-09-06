package ru.janeryshouse.invasion_planner.mapper;

import lombok.experimental.UtilityClass;
import ru.janeryshouse.invasion_planner.model.*;
import ru.janeryshouse.invasion_planner.openapi.model.*;

import java.util.UUID;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;


@UtilityClass
public class InvasionPlanMapper {

    public static InvasionPlan toEntity(InvasionPlanRequest request,
                                        AlienCivilization alienCivilization,
                                        Function<UUID, Resource> resourceFactory,
                                        Function<UUID, Target> targetFactory,
                                        Function<UUID, DefenseSystem> defenseSystemFactory) {

        return new InvasionPlan()
                .setId(UUID.randomUUID())
                .setPlanName(request.getPlanName())
                .setAlienCivilization(alienCivilization)
                .setResources(request.getResourceIds().stream()
                        .map(resourceFactory)
                        .collect(toList()))
                .setTargetList(request.getTargetIds().stream()
                        .map(targetFactory)
                        .collect(toList()))
                .setDefenseSystemList(request.getDefenseSystemIds().stream()
                        .map(defenseSystemFactory)
                        .collect(toList()));
    }

    public static InvasionPlanResponse toInvasionPlanResponse(InvasionPlan invasionPlan) {
        return  new InvasionPlanResponse()
                .id(invasionPlan.getId())
                .planName(invasionPlan.getPlanName())
                .resources(invasionPlan.getResources()
                        .stream()
                        .map(
                                resource -> new ResourceItem()
                                        .id(resource.getId())
                                        .resourceName(resource.getResourceName())
                        ).toList())
                .targets(invasionPlan.getTargetList().stream().map(
                        target -> new TargetItem()
                                .id(target.getId())
                                .targetName(target.getTargetName())
                        ).toList())
                .defenseSystems(invasionPlan.getDefenseSystemList()
                        .stream()
                        .map(defenseSystem -> new DefenseSystemItem()
                                .id(defenseSystem.getId())
                                .defenseName(defenseSystem.getSystemName()))
                                .toList()
                        );


    }

}
