package com.kn.containershipment.model

import jakarta.persistence.*

/**
 * ExecutionPlan is used to store information about shipment and its corresponding actions to be executed.
 */

@Entity
@Table(name = "execution_plan")
data class ExecutionPlan(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    val origin: String? = null,

    val destination: String? = null,

    val customerId: String? = null,

    val transportType: TransportType? = null,

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true, fetch=FetchType.LAZY)
    @JoinColumn(name = "fk_exec_plan_temperature_range_id")
    val temperature: TemperatureRange? = null,

    val fragile: Boolean = false,

    val notifyCustomer: Boolean = false,

    val templateId: Long = 0,

    @OneToMany(targetEntity = ExecutionPlanAction::class, cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "epa_fk", referencedColumnName = "id")
    val actions: MutableList<ExecutionPlanAction>? = null

)

/**
 * ExecutionPlanAction is used to execution individual actions from the template actions in an ExecutionPlan
 */
@Entity
@Table
data class ExecutionPlanAction(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    val actionName: String? = null,

    val isExecuted: Boolean = false,

    val isNotify: Boolean = false
)
