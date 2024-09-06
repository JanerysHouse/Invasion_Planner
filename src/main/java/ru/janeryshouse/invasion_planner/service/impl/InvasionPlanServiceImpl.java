package ru.janeryshouse.invasion_planner.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.janeryshouse.invasion_planner.mapper.InvasionPlanMapper;
import ru.janeryshouse.invasion_planner.model.DefenseSystem;
import ru.janeryshouse.invasion_planner.model.Resource;
import ru.janeryshouse.invasion_planner.model.Target;
import ru.janeryshouse.invasion_planner.openapi.model.InvasionPlanRequest;
import ru.janeryshouse.invasion_planner.openapi.model.InvasionPlanResponse;
import ru.janeryshouse.invasion_planner.repository.*;
import ru.janeryshouse.invasion_planner.service.InvasionPlanService;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import static ru.janeryshouse.invasion_planner.mapper.InvasionPlanMapper.toInvasionPlanResponse;

@Service
@Slf4j
@RequiredArgsConstructor
public class InvasionPlanServiceImpl implements InvasionPlanService {

    private final InvasionPlanRepository invasionPlanRepository;
    private final AlienCivilizationRepository alienCivilizationRepository;
    private final ResourceRepository resourceRepository;
    private final TargetRepository targetRepository;
    private final DefenseSystemRepository defenseSystemRepository;


    @Override
    public List<InvasionPlanResponse> getAllInvasionPlans() {
        return invasionPlanRepository.getAllBy()
                .stream()
                .map(InvasionPlanMapper::toInvasionPlanResponse)
                .toList();
    }

    @Override
    public InvasionPlanResponse getInvasionPlanById(UUID id) {
        var plan = invasionPlanRepository
                .getInvasionPlanById(id)
                .orElseThrow(() -> new RuntimeException("План вторжения не найден"));
        return toInvasionPlanResponse(plan);
    }
    

    @Override
    public InvasionPlanResponse createInvasionPlan(InvasionPlanRequest request) {
        var alienCivilization = alienCivilizationRepository.findById(request.getAlienCivilizationId())
                .orElseThrow(() -> new EntityNotFoundException("AlienCivilization not found"));

        Function<UUID, Resource> resourceFactory = id -> resourceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Resource not found"));

        Function<UUID, Target> targetFactory = id -> targetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Target not found"));

        Function<UUID, DefenseSystem> defenseSystemFactory = id -> defenseSystemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("DefenseSystem not found"));

        var invasionPlan = InvasionPlanMapper.toEntity(request, alienCivilization,
                resourceFactory, targetFactory, defenseSystemFactory);

        return toInvasionPlanResponse(invasionPlanRepository.save(invasionPlan));
    }

    @Override
    public void deleteInvasionPlan(UUID id) {
        if (id == null) {
            log.warn("Не удалось удалить план вторжения: входной id не может быть null.");
        }
        invasionPlanRepository.deleteBy(id);

    }
}
