package com.fiona.gatewayService;


//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig
//{
//  @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity){
//      serverHttpSecurity.authorizeExchange(exchangeSpec ->exchangeSpec
//                      .pathMatchers("/api/v1/premium_calculations/policy_holders/quotation",
//                              "api/v1/data_definition/service_providers/get_all_service_providers",
//                              "swagger-ui/",
//                              "/get_all_service_providers")
//
//                      .permitAll()
//                      .anyExchange()
//                      .authenticated()
//
//              )
//              .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
//      serverHttpSecurity.csrf().disable();
//      return serverHttpSecurity.build();
//  }
//  @Bean
//  public AddRequestHeaderGatewayFilterFactory addRequestHeaderFilter() {
//    return new AddRequestHeaderGatewayFilterFactory();
//  }
//}