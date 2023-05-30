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
@RequestMapping("api/ServiceProviders")
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderController {
    private String SUCCESS ="success";
    @Autowired
    private ServiceProviderService serviceProviderService;



    @PostMapping("/create")
    public ResponseEntity<APIResponse> createNewServiceProvider(@RequestBody @Valid ServiceProviderDTO payload){
        ServiceProviderDTO serviceProviderDTO = serviceProviderService.createNewServiceProvider(payload);
        return buildResponseEntity(HttpStatus.CREATED,serviceProviderDTO,"created successfully","/api/ServiceProviders/create");
    }

    //update
    @PostMapping("/update")
    public ResponseEntity<APIResponse> updateServiceProvider(@RequestBody ServiceProviderDTO payload){
        List<ServiceProviderDTO> serviceProviderDTO = serviceProviderService.updateServiceProvider(payload);
        return  buildResponseEntity(HttpStatus.ACCEPTED,serviceProviderDTO,"Updated successfully","/api/ServiceProviders/update");
    }
    //getALl

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllServiceProviders(){
        return  buildResponseEntity(HttpStatus.OK,serviceProviderService.getAllServiceProviders(),"returned All service providers","/api/ServiceProviders/all");
    }
//    @GetMapping("/serviceProvider")
//    public ResponseEntity<APIResponse> getServiceProviderByName(@RequestBody ServiceProviderDTO payload){
//        return buildResponseEntity(HttpStatus.OK,serviceProviderService.getServiceProviderByName(payload),"returned service providerr by name","api/ServiceProviders/serviceProvider");
//
//    }
    //delete
    @PostMapping("/delete")
    public ResponseEntity<APIResponse> deleteServiceProvider(@RequestBody ServiceProviderDTO payload){
        return  buildResponseEntity(HttpStatus.OK,serviceProviderService.deleteServiceProvider(payload),"deleted successfully","/api/ServiceProviders/delete");
    }

}
