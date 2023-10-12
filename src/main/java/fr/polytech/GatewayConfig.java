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
                // TODO: fix api route and then this route
                // TODO: english comments
                .route("keycloak-route", r -> r
                        .path("/api/v1/auth/login")  // Le chemin de la requête à matcher
                        .filters(f -> f.rewritePath("/api/v1/auth/login", "/realms/seasonsforce/protocol/openid-connect/token"))
                        .uri("http://keycloak-server:8080")  // L'URI de destination du service
                )
                .route("user-route", r -> r
                        .path("/api/v1/users/**") // Le chemin de la requête à matcher
                        .uri("lb://offers-api") // L'URI de destination du service
                )
                .route("address-route", r -> r
                        .path("/api/v1/address/**") // Le chemin de la requête à matcher
                        .uri("lb://address-api") // L'URI de destination du service
                )
                .route("company-route", r -> r
                        .path("/api/v1/company/**") // Le chemin de la requête à matcher
                        .uri("lb://company-api") // L'URI de destination du service
                )
                .build();
    }

}



