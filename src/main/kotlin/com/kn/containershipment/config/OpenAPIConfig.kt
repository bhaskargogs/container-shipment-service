package com.kn.containershipment.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition
class OpenAPIConfig {

    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI()
            .components(Components())
            .info(
                Info().title("Container Shipment API")
                    .version("0.0.0")
            )
    }
}