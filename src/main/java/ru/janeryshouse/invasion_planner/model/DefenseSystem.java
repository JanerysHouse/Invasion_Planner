package ru.janeryshouse.invasion_planner.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class DefenseSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String systemName;

    @ManyToMany
    @JoinTable(name = "invasion_plan_id")
    private List<InvasionPlan> invasionPlanList = new ArrayList<>();

}
