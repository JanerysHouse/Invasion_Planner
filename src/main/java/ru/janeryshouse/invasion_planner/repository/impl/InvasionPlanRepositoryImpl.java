package ru.janeryshouse.invasion_planner.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.janeryshouse.invasion_planner.model.InvasionPlan;
import ru.janeryshouse.invasion_planner.repository.InvasionPlanRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Repository
public class InvasionPlanRepositoryImpl implements InvasionPlanRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override

    public List<InvasionPlan> getAllInvasionPlans() {
        var session = entityManager.unwrap(Session.class);
        return session.createQuery("select planName from InvasionPlan", InvasionPlan.class).getResultList();

    }

    @Override
    public Optional<InvasionPlan> getInvasionPlanById(UUID id) {
        var session = entityManager.unwrap(Session.class);
        var invasionPlan = session.get(InvasionPlan.class, id);
        return Optional.ofNullable(invasionPlan);
    }

    @Override
    @Transactional
    public Optional<InvasionPlan> saveInvasionPlan(InvasionPlan invasionPlan) {
        try {
            entityManager.persist(invasionPlan);
            return Optional.ofNullable(invasionPlan);
        } catch (Exception e) {
            log.error("Ошибка при сохранении плана вторжения: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public void deleteInvasionPlan(UUID id) {
        try {
            var invasionPlan = entityManager.find(InvasionPlan.class, id);
            if (invasionPlan != null) {
                entityManager.remove(invasionPlan);
            }
        } catch (Exception e) {
            log.error("Ошибка при удалении плана вторжения с ID {}: {}", id, e.getMessage(), e);
            throw e;
        }
    }

}
