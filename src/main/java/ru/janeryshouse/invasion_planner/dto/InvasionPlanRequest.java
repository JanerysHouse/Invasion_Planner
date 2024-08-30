package ru.janeryshouse.invasion_planner.dto;

import java.util.UUID;

public record InvasionPlanRequest(UUID id,
                              String name) {
}
