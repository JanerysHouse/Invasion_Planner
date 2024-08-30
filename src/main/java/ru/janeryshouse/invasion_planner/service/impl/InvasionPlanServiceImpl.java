package ru.janeryshouse.invasion_planner.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.janeryshouse.invasion_planner.model.InvasionPlan;
import ru.janeryshouse.invasion_planner.repository.InvasionPlanRepository;
import ru.janeryshouse.invasion_planner.service.InvasionPlanService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class InvasionPlanServiceImpl implements InvasionPlanService {

    private final InvasionPlanRepository invasionPlanRepository;


    @Override
    public List<InvasionPlan> getAllInvasionPlans() {
        return invasionPlanRepository.getAllInvasionPlans();
    }

    @Override
    public Optional<InvasionPlan> getInvasionPlanById(UUID id) {
        return invasionPlanRepository
                .getInvasionPlanById(id)
                .map(Optional::of)
                .orElseThrow(() -> new RuntimeException("План вторжения не найден"));
    }

    @Override
    public Optional<InvasionPlan> createInvasionPlan(InvasionPlan invasionPlan) {
        if (invasionPlan == null) {
            log.warn("Не удалось создать план вторжения: входной объект не может быть null.");
            return Optional.empty();
        }

        return invasionPlanRepository.saveInvasionPlan(invasionPlan);
    }

    @Override
    public void deleteInvasionPlan(UUID id) {
        if (id == null) {
            log.warn("Не удалось удалить план вторжения: входной id не может быть null.");
        }
        invasionPlanRepository.deleteInvasionPlan(id);

    }
}
