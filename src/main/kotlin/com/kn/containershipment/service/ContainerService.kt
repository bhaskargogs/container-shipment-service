package com.kn.containershipment.service

import com.kn.containershipment.consumer.ShipmentReceiver
import com.kn.containershipment.model.ExecutionPlan
import com.kn.containershipment.model.ExecutionPlanAction
import com.kn.containershipment.model.PlanTemplate
import com.kn.containershipment.model.Shipment
import com.kn.containershipment.repository.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ContainerService(
    private val temperatureRangeRepository: TemperatureRangeRepository,
    private val templateRepository: TemplateRepository,
    private val shipmentRepository: ShipmentRepository,
    private val executionPlanActionRepository: ExecutionPlanActionRepository,
    private val executionPlanRepository: ExecutionPlanRepository
) {

    fun getAllShipments(): List<Shipment> {
        return shipmentRepository.findAll().toList()
    }

    fun getAllExecutionPlans(): List<ExecutionPlan> {
        return executionPlanRepository.findAll().toList()
    }

    @Transactional
    fun createExecutionPlan(shipment: Shipment, template: PlanTemplate): ExecutionPlan {
        val temperatureRange = shipment.temperatureRange?.let { temperatureRange ->
            temperatureRangeRepository.findByMinAndMax(temperatureRange.min, temperatureRange.max)
        }

        shipment.temperatureRange = temperatureRange
        template.temperatureRange = temperatureRange


        val createdShipment = shipmentRepository.save(shipment)
        val createdTemplate = templateRepository.save(template)

        val executionPlanActions = createdTemplate.actions?.mapTo(mutableListOf()) {
                action ->
            val executionPlanAction = ExecutionPlanAction(
                actionName = action.name,
                isExecuted = true,
                isNotify = false
            )
            executionPlanActionRepository.save(executionPlanAction)
        }


        var executionPlan = ExecutionPlan(
            origin = createdShipment.origin,
            destination = createdShipment.destination,
            customerId = createdShipment.customerId,
            transportType = createdShipment.transportType,
            temperature = createdShipment.temperatureRange,
            fragile = createdShipment.fragile,
            notifyCustomer = createdShipment.notifyCustomer,
            templateId = createdTemplate.id,
            actions = executionPlanActions
        )

        executionPlan = executionPlanRepository.save(executionPlan)
        return executionPlan
    }

}