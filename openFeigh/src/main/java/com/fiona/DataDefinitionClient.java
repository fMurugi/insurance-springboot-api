package com.fiona;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;


@FeignClient(name = "dataDefinitionService",url = "http://localhost:8080",configuration = Config.class)
public interface DataDefinitionClient {
    @GetMapping("/api/v1/data_definition/service_providers/get_all_service_providers")
    APIResponse<?> getServicesProvidersAndLimits() ;
}
