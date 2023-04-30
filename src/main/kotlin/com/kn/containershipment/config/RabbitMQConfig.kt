package com.kn.containershipment.config

import org.springframework.amqp.core.*
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RabbitMQConfig {

    @Value("\${containerservice.rabbitmq.queue}")
    private val queueName: String = ""

    @Value("\${containerservice.rabbitmq.exchangeName}")
    private val fanoutExchangeName: String = ""

    @Bean
    fun converter(): Jackson2JsonMessageConverter {
        return Jackson2JsonMessageConverter()
    }

    @Bean
    fun queue(): Queue {
        return Queue(queueName, false)
    }

    @Bean
    fun exchange(): FanoutExchange {
        return FanoutExchange(fanoutExchangeName)
    }

    @Bean
    fun queueToExchangeBinding(): Binding {
        return BindingBuilder.bind(queue()).to(exchange())
    }
}