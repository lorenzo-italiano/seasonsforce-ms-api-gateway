package fr.polytech;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    /**
     * Configure the routes of the gateway
     * @param builder RouteLocatorBuilder object to build the routes
     * @return RouteLocator object containing the routes
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-route", r -> r
                        .path("/api/v1/user/**") // Path of the request to match
                        .uri("lb://user-api") // Destination URI of the service
                )
                .route("offer-route", r -> r
                        .path("/api/v1/offer/**") // Path of the request to match
                        .uri("lb://offer-api") // Destination URI of the service
                )
                .route("address-route", r -> r
                        .path("/api/v1/address/**") // Path of the request to match
                        .uri("lb://address-api") // Destination URI of the service
                )
                .route("company-route", r -> r
                        .path("/api/v1/company/**") // Path of the request to match
                        .uri("lb://company-api") // Destination URI of the service
                )
                .route("invoice-route", r -> r
                        .path("/api/v1/invoice/**") // Path of the request to match
                        .uri("lb://invoice-api") // Destination URI of the service
                )
                .route("job-category-route", r -> r
                        .path("/api/v1/job-category/**") // Path of the request to match
                        .uri("lb://offer-api") // Destination URI of the service
                )
                .route("company-files-route", r -> r
                        .path("/api/v1/company-files/{param1}/{param2}")
                        .filters(f -> f.rewritePath("/api/v1/company-files/(?<param1>.*)/(?<param2>.*)", "/${param1}/${param2}"))
                        .uri("http://company-minio:9000")
                )
                .route("invoice-files-route", r -> r
                        .path("/api/v1/invoice-files/{param1}/{param2}")
                        .filters(f -> f.rewritePath("/api/v1/invoice-files/(?<param1>.*)/(?<param2>.*)", "/${param1}/${param2}"))
                        .uri("http://invoice-minio:9000")
                )
                .route("availability-route", r -> r
                        .path("/api/v1/availability/**") // Path of the request to match
                        .uri("lb://availability-api") // Destination URI of the service
                )
                .route("reference-route", r -> r
                        .path("/api/v1/reference/**") // Path of the request to match
                        .uri("lb://reference-api") // Destination URI of the service
                )
                .route("experience-route", r -> r
                        .path("/api/v1/experience/**") // Path of the request to match
                        .uri("lb://experience-api") // Destination URI of the service
                )
                .build();
    }

}



