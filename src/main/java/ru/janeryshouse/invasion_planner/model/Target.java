package ru.janeryshouse.invasion_planner.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String targetName;

    @ManyToOne
    @JoinColumn(name = "invasion_plan_id")
    private InvasionPlan invasionPlan;
}
