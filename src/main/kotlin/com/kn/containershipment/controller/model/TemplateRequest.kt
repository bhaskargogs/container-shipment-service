package com.kn.containershipment.controller.model

import com.kn.containershipment.model.PlanTemplate
import com.kn.containershipment.model.Shipment

data class TemplateRequest(
    var shipment: Shipment,
    var template: PlanTemplate
)
