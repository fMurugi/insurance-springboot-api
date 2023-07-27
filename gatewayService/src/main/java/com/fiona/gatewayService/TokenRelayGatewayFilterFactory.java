package com.fiona.gatewayService;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class TokenRelayGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenRelayGatewayFilterFactory.Config> {

    public TokenRelayGatewayFilterFactory() {
        super();
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String token = extractTokenFromRequest(exchange);
            if (token != null) {
                exchange.getRequest().mutate().header("Authorization", "Bearer " + token);
            }
            return chain.filter(exchange);
        };
    }

    // This method extracts the token from the incoming request headers.
    private String extractTokenFromRequest(ServerWebExchange exchange) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        List<String> authorizationHeader = headers.get("Authorization");
        if (authorizationHeader != null && !authorizationHeader.isEmpty()) {
            String headerValue = authorizationHeader.get(0);
            if (headerValue.startsWith("Bearer ")) {
                return headerValue.substring(7);
            }
        }
        return null;
    }

    public static class Config {
        // You can define configuration properties here if needed.
    }
}
