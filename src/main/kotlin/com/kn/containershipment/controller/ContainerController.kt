package com.kn.containershipment.controller

import com.kn.containershipment.controller.doc.ContainerDoc
import com.kn.containershipment.controller.model.TemplateRequest
import com.kn.containershipment.model.ExecutionPlan
import com.kn.containershipment.model.Shipment
import com.kn.containershipment.service.ContainerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rest/container")
@CrossOrigin(origins = ["http://localhost:4200", "http://127.0.0.1:4200"])
class ContainerController(
    private val containerService: ContainerService
): ContainerDoc {
    @GetMapping("/shipments")
    override fun getAllShipments(): List<Shipment> {
        return containerService.getAllShipments()
    }

    @GetMapping("/executionplans")
    override fun getAllExecutionPlans(): List<ExecutionPlan> {
        return containerService.getAllExecutionPlans()
    }

    @PostMapping("/executionplans")
    override fun createExecutionPlan(@RequestBody templateRequest: TemplateRequest): ExecutionPlan {
        return containerService.createExecutionPlan(templateRequest.shipment, templateRequest.template)
    }



}