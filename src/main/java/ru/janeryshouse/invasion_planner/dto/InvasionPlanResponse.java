package ru.janeryshouse.invasion_planner.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record InvasionPlanResponse(
        @NotBlank
        UUID id,
        @NotBlank
        String name) {
}
