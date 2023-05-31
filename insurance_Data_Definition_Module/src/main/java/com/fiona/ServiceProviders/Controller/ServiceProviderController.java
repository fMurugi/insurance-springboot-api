package com.fiona.ServiceProviders.Controller;

import com.fiona.Classes.APIResponse;
import com.fiona.ServiceProviders.Payload.ServiceProviderDTO;
import com.fiona.ServiceProviders.Service.ServiceProviderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.fiona.utilities.ApiResponseBuilder.buildResponseEntity;

@RestController
@RequestMapping("api/v1/service_providers")
@AllArgsConstructor

public class ServiceProviderController {
    private ServiceProviderService serviceProviderService;


    @PostMapping("/create_service_provider")
    public ResponseEntity<APIResponse> createNewServiceProvider(@RequestBody @Valid ServiceProviderDTO payload,HttpServletRequest request){
        ServiceProviderDTO serviceProviderDTO = serviceProviderService.createNewServiceProvider(payload);
        return buildResponseEntity(HttpStatus.CREATED,serviceProviderDTO,request.getRequestURI());
    }

    @PostMapping("/update_single_service_provider")
    public ResponseEntity<APIResponse> updateServiceProvider(@RequestBody ServiceProviderDTO payload,HttpServletRequest request){
        List<ServiceProviderDTO> serviceProviderDTO = serviceProviderService.updateServiceProvider(payload);
        return  buildResponseEntity(HttpStatus.ACCEPTED,serviceProviderDTO,request.getRequestURI());
    }

    @GetMapping("/get_all_service_providers")
    public ResponseEntity<APIResponse> getAllServiceProviders(HttpServletRequest request){
        return  buildResponseEntity(HttpStatus.OK,serviceProviderService.getAllServiceProviders(),request.getRequestURI());
    }

    @GetMapping("/get_service_provider_by_name")
    public ResponseEntity<APIResponse> getServiceProviderByName(@RequestBody ServiceProviderDTO payload,HttpServletRequest request){
        return buildResponseEntity(HttpStatus.OK,serviceProviderService.getServiceProviderByName(payload),request.getRequestURI());

    }

    /**
     * Deletes a single service provider based on the provided payload.
     *
     * @param payload The payload containing the details of the service provider to be deleted.
     * @return A ResponseEntity containing the API response with the deletion status.
     *
     * @apiNote This endpoint expects a POST request with the payload containing the necessary information to identify and delete the service provider.
     * The service provider will be deleted from the system.
     * The API response will include the deletion status and related information.
     * The URL for this API endpoint is "/api/ServiceProviders/delete_single_service_providers".
     *
     * @throws Exception if an error occurs during the deletion process.
     */


    @PostMapping("/delete_single_service_providers")
    public ResponseEntity<APIResponse> deleteServiceProvider(@RequestBody ServiceProviderDTO payload,HttpServletRequest request){
        return  buildResponseEntity(HttpStatus.OK,serviceProviderService.deleteServiceProvider(payload),request.getRequestURI());
    }



}
