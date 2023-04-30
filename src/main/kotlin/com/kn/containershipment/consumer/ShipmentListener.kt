package com.kn.containershipment.consumer

import com.kn.containershipment.model.ExecutionPlan
import com.kn.containershipment.model.ExecutionPlanAction
import com.kn.containershipment.model.Shipment
import com.kn.containershipment.repository.ExecutionPlanActionRepository
import com.kn.containershipment.repository.ExecutionPlanRepository
import com.kn.containershipment.repository.TemperatureRangeRepository
import com.kn.containershipment.repository.TemplateRepository
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component


@Component
class ShipmentListener(val templateRepository: TemplateRepository,
                       val temperatureRangeRepository: TemperatureRangeRepository,
                       val executionPlanActionRepository: ExecutionPlanActionRepository,
    val executionPlanRepository: ExecutionPlanRepository
) {

    @RabbitListener(queues = ["\${containerservice.rabbitmq.queue}"])
    fun receiveMessage(receiver: ShipmentReceiver) {
        val temperatureRange = temperatureRangeRepository.findByMinAndMax(receiver.temperature.min, receiver.temperature.max)

        val template = templateRepository.findByName("General Shipment Template")

        val shipment = Shipment(
            id = receiver.shipmentId,
            origin = receiver.origin,
            destination = receiver.destination,
            customerId = receiver.customerId,
            createdDate = receiver.createdDate,
            fragile = receiver.fragile,
            notifyCustomer = receiver.notifyCustomer,
            transportType = receiver.transportType,
            temperatureRange = temperatureRange)

        val executionPlanActions = template.actions?.mapTo(mutableListOf()) {
                action ->
                    val executionPlanAction = ExecutionPlanAction(
                        actionName = action.name,
                        isExecuted = true,
                        isNotify = false
                    )
                    executionPlanActionRepository.save(executionPlanAction)
        }


        val executionPlan = ExecutionPlan(
            origin = shipment.origin,
            destination = shipment.destination,
            customerId = shipment.customerId,
            transportType = shipment.transportType,
            temperature = temperatureRange,
            fragile = shipment.fragile,
            notifyCustomer = shipment.notifyCustomer,
            templateId = template.id,
            actions = executionPlanActions
        )

        executionPlanRepository.save(executionPlan)
        executionPlanRepository.findAll().forEach(::println)

    }
}