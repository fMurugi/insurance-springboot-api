package com.fiona.premiumCalculation.PolicyHolder.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fiona.premiumCalculation.Classes.APIResponse;
import com.fiona.premiumCalculation.PolicyHolder.payload.PolicyHolderDTO;
import com.fiona.premiumCalculation.PolicyHolder.service.PolicyHolderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fiona.premiumCalculation.utilities.ApiResponseBuilder.buildResponseEntity;

@RestController
@RequestMapping("api/v1/premium_calculations/policy_holders")
@AllArgsConstructor
public class PolicyHolderController {
    private final PolicyHolderService policyHolderService;


    @PostMapping("/register_policy_holder")
    public ResponseEntity<APIResponse> registerAPolicyHolder(@RequestBody @Valid PolicyHolderDTO payload, HttpServletRequest request){
        PolicyHolderDTO policyHolderDTO = policyHolderService.registerAPolicyHolder(payload);
        return buildResponseEntity(HttpStatus.CREATED,policyHolderDTO,request.getRequestURI());
    }

    @PostMapping("/update_single_policy_holder")
    public ResponseEntity<APIResponse> updatePolicyHolder(@RequestBody PolicyHolderDTO payload,HttpServletRequest request){
        List<PolicyHolderDTO> policyHolderDTO = policyHolderService.updatePolicyHolder(payload);
        return  buildResponseEntity(HttpStatus.ACCEPTED,policyHolderDTO,request.getRequestURI());
    }

    @GetMapping("/get_all_policy_holder")
    public ResponseEntity<APIResponse> getAllPolicyHolder(HttpServletRequest request){
        return  buildResponseEntity(HttpStatus.OK,policyHolderService.getAllPolicyHolder(),request.getRequestURI());
    }

    @PostMapping("/delete_single_policy_holder")
    public ResponseEntity<APIResponse> deletePolicyHolder(@RequestBody PolicyHolderDTO payload,HttpServletRequest request){
        return  buildResponseEntity(HttpStatus.OK,policyHolderService.deletePolicyHolder(payload),request.getRequestURI());
    }
    @GetMapping("/quotation")
    public ResponseEntity<APIResponse> getServiceProvidersServicesAndPremiums(HttpServletRequest request) throws JsonProcessingException {
        return buildResponseEntity(HttpStatus.OK,policyHolderService.getServiceProvidersServicesAndPremiums(),request.getRequestURI());
    }
}
