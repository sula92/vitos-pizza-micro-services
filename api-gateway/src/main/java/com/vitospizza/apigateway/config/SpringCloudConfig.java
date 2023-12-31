package com.vitospizza.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/**")
                        .uri("http://localhost:8081/"))
                .route(p -> p
                        .path("/api/**")
                        .uri("http://localhost:8090/"))
                .route(p -> p
                        .path("/api/**")
                        .uri("http://localhost:8500/"))
                        .build();
    }
}
