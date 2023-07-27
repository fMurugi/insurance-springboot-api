package com.fiona.gatewayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    private TokenRelayGatewayFilterFactory tokenRelayFilterFactory;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        TokenRelayGatewayFilterFactory.Config config = new TokenRelayGatewayFilterFactory.Config();
        // Set any configuration properties needed for the filter
        // config.setSomeProperty(someValue);

        return builder.routes()
                .route("premium_calculations_service", r -> r.path("/api/v1/premium_calculations/**")
                        .filters(f -> f.filter(tokenRelayFilterFactory.apply(config)))
                        .uri("http://localhost:8070"))
                .route("data_definition_service", r -> r.path("/api/v1/data_definition/**")
                        .filters(f -> f.filter(tokenRelayFilterFactory.apply(config)))
                        .uri("http://localhost:8080"))
                .build();
    }
}
