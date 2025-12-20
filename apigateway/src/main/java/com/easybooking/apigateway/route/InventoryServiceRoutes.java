package com.easybooking.apigateway.route;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;

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

    @Bean
    public RouterFunction<ServerResponse> inventoryserviceApiDocs() {
        return GatewayRouterFunctions.route("booking-service-api-docs")
                .route(RequestPredicates.path("/docs/inventoryservice/v3/api-docs"),
                        http())
                .before(uri("http://localhost:8080"))
                .filter((request, next) -> {
                    ServerRequest modifiedRequest = ServerRequest.from(request)
                            .uri(URI.create("http://localhost:8080/v3/api-docs"))
                            .build();
                    return next.handle(modifiedRequest);
                })
                .build();
    }
}
