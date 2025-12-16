package com.easybooking.apigateway.route;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.web.servlet.function.RequestPredicates.*;

@Configuration
public class InventoryServiceRoutes {

    private static final String INVENTORY_SERVICE_URL = "http://localhost:8080/";

    @Bean
    public RouterFunction<ServerResponse> inventoryRoutes(){
        return GatewayRouterFunctions.route("inventory-service")

                .route(GET("/api/v1/inventory/events"), http())
                .before(uri(INVENTORY_SERVICE_URL))

                .route(GET("/api/v1/inventory/venue/{venueId}"), http())
                .before(uri(INVENTORY_SERVICE_URL))

                .route(GET("/api/v1/inventory/event/{event_id}"), http())
                .before(uri(INVENTORY_SERVICE_URL))

                .route(PUT("/api/v1/inventory/event/{eventId}/capacity/{capacity}"), http())
                .before(uri(INVENTORY_SERVICE_URL))

                .build();
    }
}
