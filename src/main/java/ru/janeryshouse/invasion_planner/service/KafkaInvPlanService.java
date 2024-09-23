package ru.janeryshouse.invasion_planner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.janeryshouse.invasion_planner.model.InvasionPlan;

import java.util.logging.Logger;

@RequiredArgsConstructor
@Service
public class KafkaInvPlanService {

    public static final Logger logger = Logger.getLogger(KafkaInvPlanService.class.getName());
    @KafkaListener(topics = "plan", containerFactory = "invasionPlanListenerFactory")
    public void consumeInvasionPlan(InvasionPlan invasionPlan) {
        logger.info("Consume invasion plan: " + invasionPlan.toString());
    }
}
