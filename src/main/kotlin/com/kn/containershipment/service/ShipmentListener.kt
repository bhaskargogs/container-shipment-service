package com.kn.containershipment.service

import com.kn.containershipment.model.Shipment
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component


@Component
class ShipmentListener {

    @RabbitListener(queues = ["\${containerservice.rabbitmq.queue}"])
    fun receiveMessage(shipment: Shipment) {
        println("Received <$shipment>")
    }
}