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
                        .uri("http://offers-api:8080/api/v1/users") // L'URI de destination du service
                )
                // TODO Ajoutez d'autres routes
                .build();
    }

}



