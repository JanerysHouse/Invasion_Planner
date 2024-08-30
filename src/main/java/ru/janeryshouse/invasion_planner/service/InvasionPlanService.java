package ru.janeryshouse.invasion_planner.service;

import ru.janeryshouse.invasion_planner.model.InvasionPlan;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvasionPlanService {

    public List<InvasionPlan> getAllInvasionPlans();
    public Optional<InvasionPlan> getInvasionPlanById(UUID id);
    public Optional<InvasionPlan> createInvasionPlan(InvasionPlan invasionPlan);
    public void deleteInvasionPlan(UUID id);
}
