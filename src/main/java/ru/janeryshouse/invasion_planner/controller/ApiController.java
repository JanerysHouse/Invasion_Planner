package ru.janeryshouse.invasion_planner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import ru.janeryshouse.invasion_planner.openapi.InvasionPlansApi;
import ru.janeryshouse.invasion_planner.openapi.model.InvasionPlanRequest;
import ru.janeryshouse.invasion_planner.openapi.model.InvasionPlanResponse;
import ru.janeryshouse.invasion_planner.service.InvasionPlanService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ApiController implements InvasionPlansApi {

    private final InvasionPlanService invasionPlanService;


    @Override
    public Optional<NativeWebRequest> getRequest() {
        return InvasionPlansApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> deleteInvasionPlanById(UUID id) {
        invasionPlanService.deleteInvasionPlan(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<InvasionPlanResponse> createInvasionPlan(InvasionPlanRequest invasionPlanRequest) {
        return ResponseEntity.ok(invasionPlanService.createInvasionPlan(invasionPlanRequest));
    }

    @Override
    public ResponseEntity<InvasionPlanResponse> getInvasionPlanById(UUID id) {
        return ResponseEntity.ok(invasionPlanService.getInvasionPlanById(id));
    }

    @Override
    public ResponseEntity<List<InvasionPlanResponse>> getAllInvasionPlans() {
        return ResponseEntity.ok(invasionPlanService.getAllInvasionPlans());
    }
}
