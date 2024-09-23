package ru.janeryshouse.invasion_planner.event;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.*;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.janeryshouse.invasion_planner.model.InvasionPlan;

@Component
@RequiredArgsConstructor
public class InvasionHibernateEventListener implements PostDeleteEventListener, PostInsertEventListener, PostUpdateEventListener {

    private final EntityManagerFactory entityManagerFactory;
    private final KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void onPostDelete(PostDeleteEvent postDeleteEvent) {
        Object entity = postDeleteEvent.getEntity();
        if (entity instanceof InvasionPlan invasionPlan) {
            kafkaTemplate.send("plan", invasionPlan.toString());
        }

    }

    @Override
    public void onPostInsert(PostInsertEvent postInsertEvent) {
        Object entity = postInsertEvent.getEntity();
        if (entity instanceof InvasionPlan invasionPlan) {
            kafkaTemplate.send("plan", invasionPlan.toString());
        }

    }

    @Override
    public void onPostUpdate(PostUpdateEvent postUpdateEvent) {
        Object entity = postUpdateEvent.getEntity();
        if (entity instanceof InvasionPlan invasionPlan) {
            kafkaTemplate.send("plan", invasionPlan.toString());
        }

    }

    @Override
    public boolean requiresPostCommitHandling(EntityPersister entityPersister) {
        return true;
    }

    @PostConstruct
    private void postConstruct() {
        SessionFactoryImplementor sessionFactory = entityManagerFactory.unwrap(SessionFactoryImplementor.class);
        EventListenerRegistry registry = sessionFactory
                .getServiceRegistry()
                .getService(EventListenerRegistry.class);
        assert registry != null;
        registry.prependListeners(EventType.POST_COMMIT_DELETE, this);
        registry.prependListeners(EventType.POST_COMMIT_INSERT, this);
        registry.prependListeners(EventType.POST_COMMIT_UPDATE, this);
    }
}