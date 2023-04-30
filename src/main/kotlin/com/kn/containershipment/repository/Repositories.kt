package com.kn.containershipment.repository

import com.kn.containershipment.model.*
import org.springframework.data.repository.CrudRepository

interface TemplateRepository : CrudRepository<PlanTemplate, Long> {
    fun findByName(name: String): PlanTemplate
}

interface ActionRepository : CrudRepository<Action, Long>
interface TemperatureRangeRepository : CrudRepository<TemperatureRange, Long> {
    fun findByMinAndMax(min: Int, max: Int): TemperatureRange?
}

interface ExecutionPlanActionRepository : CrudRepository<ExecutionPlanAction, Long>

interface ExecutionPlanRepository : CrudRepository<ExecutionPlan, Long>