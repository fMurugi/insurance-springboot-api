package com.fiona.Limits.controller;

import com.fiona.Classes.APIResponse;
import com.fiona.Limits.model.PremiumLimitDTO;
import com.fiona.Limits.service.LimitsService;
import com.fiona.ServiceProviders.Model.ServiceProviderDTO;
import com.fiona.ServiceProviders.Service.ServiceProviderService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fiona.utilities.ApiResponseBuilder.buildResponseEntity;

@RestController
@RequestMapping("/api/limits")
@Tag(name="premium limits")
public class PremiumLimitController {
    @Autowired
    private LimitsService limitsService;

    @Operation(
            description = "Get endpoint for premium limits",
            summary = "these are amount to be paid per age bracket",
            responses = {
                    @ApiResponse(
                            description = "success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "UnAuthorized",
                            responseCode = "403"
                    )
            }
    )
    @Hidden
    @PostMapping("/create")
    public ResponseEntity<APIResponse> createNewLimits(@RequestBody @Valid PremiumLimitDTO payload){
        PremiumLimitDTO premiumLimitDTO = limitsService.createNewPremiumLimit(payload);
        return buildResponseEntity(HttpStatus.CREATED,premiumLimitDTO,"created successfully","/api/limits/create");
    }

    @Hidden
    //update
    @PostMapping("/update")
    public ResponseEntity<APIResponse> updateLimit(@RequestBody PremiumLimitDTO payload){
        List<PremiumLimitDTO> premiumLimitDTOList = limitsService.updateLimit(payload);
        return  buildResponseEntity(HttpStatus.ACCEPTED,premiumLimitDTOList,"Updated successfully","/api/limits/update");
    }
    //getALl
    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllLimits(){
        return  buildResponseEntity(HttpStatus.OK,limitsService.getAllLimits(),"returned All limits","/api/limits/all");
    }

    //delete
    @Hidden
    @PostMapping("/delete")
    public ResponseEntity<APIResponse> deleteLimit(@RequestBody PremiumLimitDTO payload){
        return  buildResponseEntity(HttpStatus.OK,limitsService.deleteLimit(payload),"deleted successfully","/api/limits/delete");
    }

}
