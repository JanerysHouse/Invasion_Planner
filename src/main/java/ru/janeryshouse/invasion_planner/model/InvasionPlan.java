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
public class InvasionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String planName;

    @ManyToOne
    @JoinColumn(name = "alien_civilization_id")
    private AlienCivilization alienCivilization;

    @ManyToMany
    @JoinTable(
            name = "invasion_plan_resource",
            joinColumns = @JoinColumn(name = "invasion_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private List<Resource> resources = new ArrayList<>();

    @OneToMany(mappedBy = "invasionPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Target> targetList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "invasion_plan_defense_system_list",
            joinColumns = @JoinColumn(name = "invasion_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "defense_system_list")
    )
    private List<DefenseSystem> defenseSystemList = new ArrayList<>();
}
