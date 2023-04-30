package com.kn.containershipment.config

import com.kn.containershipment.model.Action
import com.kn.containershipment.model.TemperatureRange
import com.kn.containershipment.model.PlanTemplate
import com.kn.containershipment.repository.*
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.Transactional


@Configuration
class Config {

    @Bean
    @Throws(Exception::class)
    @Transactional
    fun run(templateRepository: TemplateRepository,
            actionRepository: ActionRepository,
            temperatureRangeRepository: TemperatureRangeRepository,
            executionActionPlanRepository: ExecutionPlanActionRepository,
            executionPlanRepository: ExecutionPlanRepository
    ): CommandLineRunner {
        return CommandLineRunner {

            // Cleaning up database initially
            templateRepository.deleteAll()
            temperatureRangeRepository.deleteAll()
            actionRepository.deleteAll()
            executionActionPlanRepository.deleteAll()
            executionPlanRepository.deleteAll()


            val temperatureRange = TemperatureRange(id = 1, min = -20, max = -10)

            temperatureRangeRepository.save(temperatureRange)

            val action1 = Action(id = 1, name = "shipment is taken from customer")
            val action2 = Action(id = 2, name = "shipment is on the way")
            val action3 = Action(id = 3, name = "shipment is arrived to destination")
            val action4 = Action(id = 4, name = "shipment is handover to the destination target")

            val actionList = mutableListOf(action1, action2, action3, action4)
            actionList.map {
                action -> actionRepository.findById(action.id).orElse(actionRepository.save(action))
            }
            
            val defaultPlanTemplate = PlanTemplate(id = 999, name = "General Shipment Template", actions = actionList, temperatureRange = temperatureRange)

            templateRepository.save(defaultPlanTemplate)
            templateRepository.findAll().forEach(::print)
        }
    }

}