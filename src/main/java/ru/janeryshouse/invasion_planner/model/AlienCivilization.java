package ru.janeryshouse.invasion_planner.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@Entity
public class AlienCivilization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "alienCivilization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvasionPlan> invasionPlan = new ArrayList<>();

    @OneToMany(mappedBy = "alienCivilization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlienFleet> alienFleetList = new ArrayList<>();

}
