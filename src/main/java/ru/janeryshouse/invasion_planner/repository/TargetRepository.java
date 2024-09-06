package ru.janeryshouse.invasion_planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.janeryshouse.invasion_planner.model.Target;

import java.util.UUID;

public interface TargetRepository extends JpaRepository<Target, UUID> {
}
