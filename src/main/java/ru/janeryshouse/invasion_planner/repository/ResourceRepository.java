package ru.janeryshouse.invasion_planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.janeryshouse.invasion_planner.model.Resource;

import java.util.UUID;

public interface ResourceRepository extends JpaRepository<Resource, UUID> {
}
