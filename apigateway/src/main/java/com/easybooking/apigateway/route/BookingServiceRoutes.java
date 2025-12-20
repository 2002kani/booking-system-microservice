package com.easybooking.apigateway.route;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.*;

import java.net.URI;

import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.setPath;
import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration
public class BookingServiceRoutes {

    @Bean
    public RouterFunction<ServerResponse> bookingRoutes(){
        return GatewayRouterFunctions.route("booking-service")
                .route(RequestPredicates.POST("/api/v1/booking"),
                        http())
                    .before(uri("http://localhost:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> bookingServiceApiDocs() {
        return GatewayRouterFunctions.route("booking-service-api-docs")
                .route(RequestPredicates.path("/docs/bookingservice/v3/api-docs"),
                        http())
                    .before(uri("http://localhost:8081"))
                .filter((request, next) -> {
                    ServerRequest modifiedRequest = ServerRequest.from(request)
                            .uri(URI.create("http://localhost:8081/v3/api-docs"))
                            .build();
                    return next.handle(modifiedRequest);
                })
                .build();
    }

}
