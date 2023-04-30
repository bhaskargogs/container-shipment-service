package com.kn.containershipment.controller.doc

import com.kn.containershipment.consumer.ShipmentReceiver
import com.kn.containershipment.model.ExecutionPlan
import com.kn.containershipment.model.Shipment
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "Container API", description = "Api used for Container shipping related operations")
interface ContainerDoc {

    @Operation(summary = "Get all Shipments")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successfully retrieved all Shipments")
        ]
    )
    fun getAllShipments(): List<Shipment>

    @Operation(summary = "Get all Execution Plans")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successfully retrieved all execution plans")
        ]
    )
    fun getAllExecutionPlans(): List<ExecutionPlan>

    @Operation(summary = "Create an Execution Plan")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Successfully created an execution plan")
        ]
    )
    fun createExecutionPlan(shipment: ShipmentReceiver): ExecutionPlan
}