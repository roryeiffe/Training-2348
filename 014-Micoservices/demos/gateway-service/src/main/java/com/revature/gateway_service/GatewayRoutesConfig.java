package com.revature.gateway_service;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        // routes() method indicates that we are defining routes for our app and where to forward
        // the requests
        return builder.routes()
                // .route() lets us define a particular route pattern and where to delegate that request
                .route("workshop-service", r -> r.path("/workshops", "/workshops/**")
                // .uri() takes in the location to which we should forward these requests
                // lb - indicates that we should delegate to load balancer and specify which service
                // We could also use http to specify a direct route
                .uri("lb://workshop-service"))

                // handle requests to the registration service:
                .route("registration-service", r->r.path("/registrations", "/registrations/**")
                        .uri("lb://registration-service"))

                // block internal endpoints:
                .route("block-internal", r->r.path("/internal", "/internal/**")
                        .filters(f -> f.setStatus(404))
                        .uri("no://op"))

                // after all routes are defined, we build
                .build();


    }
}
