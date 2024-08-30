package ru.janeryshouse.invasion_planner.repository;

import ru.janeryshouse.invasion_planner.model.InvasionPlan;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvasionPlanRepository {

    public List<InvasionPlan> getAllInvasionPlans();
    public Optional<InvasionPlan> getInvasionPlanById(UUID id);
    public Optional<InvasionPlan> saveInvasionPlan(InvasionPlan invasionPlan);
    public void deleteInvasionPlan(UUID id);


}
