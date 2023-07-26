package com.fiona.gatewayService;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig
{
  @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity){
      serverHttpSecurity.authorizeExchange(exchangeSpec ->exchangeSpec
                      .pathMatchers("/api/v1/premium_calculations/policy_holders/quotation",
                              "api/v1/data_definition/service_providers/get_all_service_providers",
                              "swagger-ui/",
                              "/get_all_service_providers")

                      .permitAll()
                      .anyExchange()
                      .authenticated()

              )
              .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
      serverHttpSecurity.csrf().disable();
      return serverHttpSecurity.build();
  }
}