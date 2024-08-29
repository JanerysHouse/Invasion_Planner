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
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String resourceName;

    @ManyToMany(mappedBy = "resources")
    private List<InvasionPlan> invasionPlans = new ArrayList<>();
}
