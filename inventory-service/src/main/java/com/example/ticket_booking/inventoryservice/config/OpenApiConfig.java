package com.example.ticket_booking.inventoryservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI inventoryServiceApi() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Inventory Service API")
                        .description("Complete Inventory Service API by Kani Karadag")
                        .version("v1.0.0"));
    }
}
