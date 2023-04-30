package com.kn.containershipment.service

import com.kn.containershipment.consumer.ShipmentReceiver
import com.kn.containershipment.model.ExecutionPlan
import com.kn.containershipment.model.Shipment
import com.kn.containershipment.repository.ExecutionPlanRepository
import com.kn.containershipment.repository.ShipmentRepository
import org.springframework.stereotype.Service

@Service
class ContainerService(
    private val shipmentRepository: ShipmentRepository,
    private val executionPlanRepository: ExecutionPlanRepository
) {

    fun getAllShipments(): List<Shipment> {
        return shipmentRepository.findAll().toList()
    }

    fun getAllExecutionPlans(): List<ExecutionPlan> {
        return executionPlanRepository.findAll().toList()
    }

    fun createExecutionPlan(shipmentRequest: ShipmentReceiver): ExecutionPlan {
        TODO()
    }

}