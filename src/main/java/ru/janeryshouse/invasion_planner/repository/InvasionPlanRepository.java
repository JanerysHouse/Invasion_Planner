package ru.janeryshouse.invasion_planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.janeryshouse.invasion_planner.model.InvasionPlan;

import java.util.Optional;
import java.util.UUID;

public interface InvasionPlanRepository extends JpaRepository<InvasionPlan, UUID> {

    Optional<InvasionPlan> getInvasionPlanById(UUID id);

    Optional<InvasionPlan> getAllBy();
}
