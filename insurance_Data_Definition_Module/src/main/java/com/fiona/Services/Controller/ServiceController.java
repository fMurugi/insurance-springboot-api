package com.fiona.Services.Controller;

import com.fiona.Classes.APIResponse;
import com.fiona.Services.payload.ServicesDTO;
import com.fiona.Services.Service.ServicesService;
import com.mysql.cj.PreparedQuery;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<APIResponse> createNewService(@RequestBody @Valid ServicesDTO payload, HttpServletRequest request){
        ServicesDTO servicesDTO = servicesService.createNewService(payload);
        return buildResponseEntity(HttpStatus.CREATED,servicesDTO,request.getRequestURI());
    }

    //getALl
    @GetMapping("/get_all_services")
    public ResponseEntity<APIResponse> getAllServices(HttpServletRequest request){
        return  buildResponseEntity(HttpStatus.OK,servicesService.getAllServices(),request.getRequestURI());
    }

    //update
    @PostMapping("/update_single_service")
    public ResponseEntity<APIResponse> updateService(@RequestBody ServicesDTO payload,HttpServletRequest request){
        List<ServicesDTO> servicesDTOList = servicesService.updateService(payload);
        return  buildResponseEntity(HttpStatus.ACCEPTED,servicesDTOList,request.getRequestURI());
    }

    //delete
    @PostMapping("/delete_single_service")
    public ResponseEntity<APIResponse> deleteService(@RequestBody ServicesDTO payload,HttpServletRequest request){
        return  buildResponseEntity(HttpStatus.OK,servicesService.deleteService(payload),request.getRequestURI());
    }



}
