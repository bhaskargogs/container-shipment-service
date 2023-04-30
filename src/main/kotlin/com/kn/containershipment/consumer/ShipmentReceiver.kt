package com.kn.containershipment.consumer

import com.kn.containershipment.model.TransportType

data class ShipmentReceiver(
    val shipmentId: Long = 0,
    val origin: String? = null,
    val destination: String? = null,
    val customerId: String? = null,
    val createdDate: Long = 0,
    val fragile: Boolean = false,
    val notifyCustomer: Boolean = false,
    val transportType: TransportType? = null,
    val temperature: TemperatureRangeReceiver = TemperatureRangeReceiver()
)

data class TemperatureRangeReceiver(
    val min: Int = 0,
    val max: Int = 0
)

