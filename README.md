# API Gateway 
##### for SeasonsForce Project

## Description
This is the API Gateway for the SeasonsForce project. It is a Spring Boot application that uses the Spring Cloud Gateway library to route requests to the appropriate microservice. It also uses the Eureka library to register itself as a service with the Eureka server. This allows the api gateway to discover the other microservices and route requests to them.

## How to add a new route
In order to add a new route to the API Gateway, you must add a new route to the GatewayConfig class. The following is an example of a route that forwards requests to the /api/seasons endpoint to the seasons microservice.

``` java

public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
    return builder.routes()
        .route(r -> r.path("/api/example/**")
            .uri("lb://example-service"))
        // Add new routes below here
        .route(r -> r.path("/api/seasons/**")
            .uri("lb://seasons-service"))
        // End of new route
        .build();
}
```

It is important to note that the uri starts with "lb://". This is because the API Gateway uses the Eureka library to discover the microservices. The "lb://" prefix tells the API Gateway to use the Discovery Service to route requests to the microservice. The Discovery Service will then tell the API Gateway which uri of the microservice to route the request to.

## Devs: Romain Frezier & Lorenzo Italiano