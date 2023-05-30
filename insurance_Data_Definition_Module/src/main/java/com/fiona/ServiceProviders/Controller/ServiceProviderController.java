package com.fiona.ServiceProviders.Controller;

import com.fiona.Classes.APIResponse;
import com.fiona.ServiceProviders.Model.ServiceProviderDTO;
import com.fiona.ServiceProviders.Service.ServiceProviderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fiona.utilities.ApiResponseBuilder.buildResponseEntity;

@RestController
@RequestMapping("api/v1/ServiceProviders")
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderController {
    private String SUCCESS ="success";
    @Autowired
    private ServiceProviderService serviceProviderService;

    @PostMapping("/create_service_provider")
    public ResponseEntity<APIResponse> createNewServiceProvider(@RequestBody @Valid ServiceProviderDTO payload){
        ServiceProviderDTO serviceProviderDTO = serviceProviderService.createNewServiceProvider(payload);
        return buildResponseEntity(HttpStatus.CREATED,serviceProviderDTO,"created successfully","/api/ServiceProviders/create_service_provider");
    }


    @PostMapping("/update_single_service_provider")
    public ResponseEntity<APIResponse> updateServiceProvider(@RequestBody ServiceProviderDTO payload){
        List<ServiceProviderDTO> serviceProviderDTO = serviceProviderService.updateServiceProvider(payload);
        return  buildResponseEntity(HttpStatus.ACCEPTED,serviceProviderDTO,"Updated successfully","/api/ServiceProviders/update_service_provider");
    }

    @GetMapping("/get_all_service_providers")
    public ResponseEntity<APIResponse> getAllServiceProviders(){
        return  buildResponseEntity(HttpStatus.OK,serviceProviderService.getAllServiceProviders(),"returned All service providers","/api/ServiceProviders/all");
    }

    @GetMapping("/get_service_provider_by_name")
    public ResponseEntity<APIResponse> getServiceProviderByName(@RequestBody ServiceProviderDTO payload){
        return buildResponseEntity(HttpStatus.OK,serviceProviderService.getServiceProviderByName(payload),"returned service providerr by name","api/ServiceProviders/serviceProvider");

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
    public ResponseEntity<APIResponse> deleteServiceProvider(@RequestBody ServiceProviderDTO payload){
        return  buildResponseEntity(HttpStatus.OK,serviceProviderService.deleteServiceProvider(payload),"deleted successfully","/api/ServiceProviders/delete_single_service_providers");
    }

}
