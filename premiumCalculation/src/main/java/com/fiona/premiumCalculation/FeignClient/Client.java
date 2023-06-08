package com.fiona.premiumCalculation.FeignClient;

import com.fiona.premiumCalculation.Classes.APIResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "dataDefinition",url = "http://ocalhost:8080/api/v1/data_definition/service_providers")
public interface Client {
    @GetMapping("/get_service_providers_premiums")
    APIResponse<?> getServicesProvidersAndLimits();
}
