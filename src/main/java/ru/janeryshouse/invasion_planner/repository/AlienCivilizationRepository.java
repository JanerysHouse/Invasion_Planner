package ru.janeryshouse.invasion_planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.janeryshouse.invasion_planner.model.AlienCivilization;

import java.util.UUID;

public interface AlienCivilizationRepository extends JpaRepository<AlienCivilization, UUID> {
}
