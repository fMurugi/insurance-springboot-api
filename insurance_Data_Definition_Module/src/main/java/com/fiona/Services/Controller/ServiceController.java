package com.fiona.Services.Controller;

import com.fiona.Classes.APIResponse;
import com.fiona.Services.payload.ServicesDTO;
import com.fiona.Services.Service.ServicesService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.fiona.utilities.ApiResponseBuilder.buildResponseEntity;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/data_definition/Services")
public class ServiceController {
    private ServicesService servicesService;

    /**
     * @param payload
     * @return
     */
    @PostMapping("/create_service")
    public ResponseEntity<APIResponse> createNewService(@RequestBody  ServicesDTO payload, HttpServletRequest request){
        ServicesDTO servicesDTO = servicesService.createNewService(payload);
        return buildResponseEntity(HttpStatus.CREATED,servicesDTO,request.getRequestURI());
    }

    @GetMapping("/get_all_services")
    public ResponseEntity<APIResponse> getAllServices(HttpServletRequest request){
        return  buildResponseEntity(HttpStatus.OK,servicesService.getAllServices(),request.getRequestURI());
    }

    @PostMapping("/update_single_service")
    public ResponseEntity<APIResponse> updateService(@RequestBody ServicesDTO payload,HttpServletRequest request){
        List<ServicesDTO> servicesDTOList = servicesService.updateService(payload);
        return  buildResponseEntity(HttpStatus.ACCEPTED,servicesDTOList,request.getRequestURI());
    }

    @PostMapping("/delete_single_service")
    public ResponseEntity<APIResponse> deleteService(@RequestBody ServicesDTO payload,HttpServletRequest request){
        return  buildResponseEntity(HttpStatus.OK,servicesService.deleteService(payload),request.getRequestURI());
    }

    @PostMapping("/fetch_services_by_service_provider")
    public ResponseEntity<APIResponse> getServicesByServiceProviderId(@RequestBody ServicesDTO payload, HttpServletRequest request){
        return  buildResponseEntity(HttpStatus.OK,servicesService.getServicesByServiceProviderId(payload),request.getRequestURI());
    }


}
