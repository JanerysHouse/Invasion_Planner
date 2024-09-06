package ru.janeryshouse.invasion_planner.service;

import ru.janeryshouse.invasion_planner.openapi.model.InvasionPlanRequest;
import ru.janeryshouse.invasion_planner.openapi.model.InvasionPlanResponse;

import java.util.List;
import java.util.UUID;

public interface InvasionPlanService {

    List<InvasionPlanResponse> getAllInvasionPlans();
    InvasionPlanResponse getInvasionPlanById(UUID id);
    InvasionPlanResponse createInvasionPlan(InvasionPlanRequest request);
    void deleteInvasionPlan(UUID id);
}
