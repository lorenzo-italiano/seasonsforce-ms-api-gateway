package fr.polytech;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //TODO fix api route and then this route
                .route("user-route", r -> r
                        .path("/api/v1/users/**") // Le chemin de la requête à matcher
                        .uri("lb://offers-api") // L'URI de destination du service
                )
                .route("address-route", r -> r
                        .path("/api/v1/address/**") // Le chemin de la requête à matcher
                        .uri("lb://address-api") // L'URI de destination du service
                )
                .build();
    }

}



