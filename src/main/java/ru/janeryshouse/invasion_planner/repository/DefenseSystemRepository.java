package ru.janeryshouse.invasion_planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.janeryshouse.invasion_planner.model.DefenseSystem;

import java.util.UUID;

public interface DefenseSystemRepository extends JpaRepository<DefenseSystem, UUID> {
}
