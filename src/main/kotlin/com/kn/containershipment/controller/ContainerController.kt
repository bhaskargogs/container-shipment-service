package com.kn.containershipment.controller

import com.kn.containershipment.consumer.ShipmentReceiver
import com.kn.containershipment.controller.doc.ContainerDoc
import com.kn.containershipment.model.ExecutionPlan
import com.kn.containershipment.model.Shipment
import com.kn.containershipment.service.ContainerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/container")
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
    override fun createExecutionPlan(@RequestBody shipment: ShipmentReceiver): ExecutionPlan {
        TODO()
    }



}