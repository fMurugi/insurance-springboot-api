package com.fiona.premiumCalculation.Config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
      info = @Info(
              contact = @Contact(
                      name = "fiona",
                      email="fionamurugi99@gmail.com"
              ),
              description="OpenAPI documentation for spring boot app",
              title = "OpenAPi specifications",
              version = "1.0.0",
              termsOfService = "terms of service",
              license = @License(


      )

      ),
        servers ={
              @Server(
                      description = "local ENV",
                      url= "http://localhost:8080"
              ),
                @Server(
                        description = "PROD ENV",
                        url= "http://fiona.com/apis"
                )
        }
)
public class OpenAPiConfig {
}
