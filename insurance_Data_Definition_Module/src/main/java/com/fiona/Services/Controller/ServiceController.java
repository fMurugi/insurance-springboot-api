package com.fiona.Services.Controller;

import com.fiona.Classes.APIResponse;
import com.fiona.ServiceProviders.Model.ServiceProviderDTO;
import com.fiona.Services.Model.ServicesDTO;
import com.fiona.Services.Service.ServicesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fiona.utilities.ApiResponseBuilder.buildResponseEntity;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Services")
public class ServiceController {
    private ServicesService servicesService;

    /**
     * @param payload
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<APIResponse> createNewService(@RequestBody @Valid ServicesDTO payload){
        ServicesDTO servicesDTO = servicesService.createNewService(payload);
        return buildResponseEntity(HttpStatus.CREATED,servicesDTO,"created successfully","/api/Services/create");
    }

    //getALl
    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllServices(){
        return  buildResponseEntity(HttpStatus.OK,servicesService.getAllServices(),"returned All services","/api/Services/all");
    }

    //update
    @PostMapping("/update")
    public ResponseEntity<APIResponse> updateService(@RequestBody ServicesDTO payload){
        List<ServicesDTO> servicesDTOList = servicesService.updateService(payload);
        return  buildResponseEntity(HttpStatus.ACCEPTED,servicesDTOList,"Updated successfully","/api/Services/update");
    }

    //delete
    @PostMapping("/delete")
    public ResponseEntity<APIResponse> deleteService(@RequestBody ServicesDTO payload){
        return  buildResponseEntity(HttpStatus.OK,servicesService.deleteService(payload),"deleted successfully","/api/Services/delete");
    }



}
