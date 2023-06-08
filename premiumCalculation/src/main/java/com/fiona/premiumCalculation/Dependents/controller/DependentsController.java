package com.fiona.premiumCalculation.Dependents.controller;

import com.fiona.premiumCalculation.Classes.APIResponse;
import com.fiona.premiumCalculation.Dependents.payload.DependentsDTO;
import com.fiona.premiumCalculation.Dependents.service.DependentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fiona.premiumCalculation.utilities.ApiResponseBuilder.buildResponseEntity;

@RestController
@RequestMapping("api/v1/premium_calculations/dependents")
@AllArgsConstructor
public class DependentsController {
    private final DependentService dependentService;

    @PostMapping("/register_dependant")
    public ResponseEntity<APIResponse> registerDependent(@RequestBody @Valid DependentsDTO payload, HttpServletRequest request){
        DependentsDTO dependentsDTO = dependentService.registerDependent(payload);
        return buildResponseEntity(HttpStatus.CREATED,dependentsDTO,request.getRequestURI());
    }

    @PostMapping("/update_dependent")
    public ResponseEntity<APIResponse> updateDependent(@RequestBody DependentsDTO payload,HttpServletRequest request){

        List<DependentsDTO> dependentsDTOS = dependentService.updateDependents(payload);
        return  buildResponseEntity(HttpStatus.ACCEPTED,dependentsDTOS,request.getRequestURI());
    }

    @GetMapping("/get_all_dependent")
    public ResponseEntity<APIResponse> getAllDependents(HttpServletRequest request){
        return  buildResponseEntity(HttpStatus.OK,dependentService.getAllDependents(),request.getRequestURI());
    }

    @PostMapping("/delete_single_dependent")
    public ResponseEntity<APIResponse> deleteDependent(@RequestBody DependentsDTO payload,HttpServletRequest request){
        return  buildResponseEntity(HttpStatus.OK,dependentService.deleteDependent(payload),request.getRequestURI());
    }

}
