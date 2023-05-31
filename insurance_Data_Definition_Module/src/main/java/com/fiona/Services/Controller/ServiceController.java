package com.fiona.Services.Controller;

import com.fiona.Classes.APIResponse;
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
@RequestMapping("/api/v1/Services")
public class ServiceController {
    private ServicesService servicesService;

    /**
     * @param payload
     * @return
     */
    @PostMapping("/create_service")
    public ResponseEntity<APIResponse> createNewService(@RequestBody @Valid ServicesDTO payload){
        ServicesDTO servicesDTO = servicesService.createNewService(payload);
        return buildResponseEntity(HttpStatus.CREATED,servicesDTO,"created successfully","/api/Services/create_service");
    }

    //getALl
    @GetMapping("/get_all_services")
    public ResponseEntity<APIResponse> getAllServices(){
        return  buildResponseEntity(HttpStatus.OK,servicesService.getAllServices(),"returned All services","/api/Services/get_all_services");
    }

    //update
    @PostMapping("/update_single_service")
    public ResponseEntity<APIResponse> updateService(@RequestBody ServicesDTO payload){
        List<ServicesDTO> servicesDTOList = servicesService.updateService(payload);
        return  buildResponseEntity(HttpStatus.ACCEPTED,servicesDTOList,"Updated successfully","/api/Services/update_single_service");
    }

    //delete
    @PostMapping("/delete_single_service")
    public ResponseEntity<APIResponse> deleteService(@RequestBody ServicesDTO payload){
        return  buildResponseEntity(HttpStatus.OK,servicesService.deleteService(payload),"deleted successfully","/api/Services/delete_single_service");
    }



}
