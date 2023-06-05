package com.fiona.Limits.controller;

import com.fiona.Classes.APIResponse;
import com.fiona.Limits.Payload.PremiumLimitDTO;
import com.fiona.Limits.service.LimitsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.fiona.utilities.ApiResponseBuilder.buildResponseEntity;

@RestController
@RequestMapping("/api/v1/limits")
@Tag(name="premium limits")
@AllArgsConstructor
public class PremiumLimitController {
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

//    todo why are we hiding the endpoint create ???? --it was trial  -romoved the @hidden -done
    @PostMapping("/create_premium_limit")
    public ResponseEntity<APIResponse> createNewLimits(@RequestBody @Valid PremiumLimitDTO payload){
        List<PremiumLimitDTO> premiumLimitDTO = limitsService.createNewPremiumLimit(payload);
        return buildResponseEntity(HttpStatus.CREATED,premiumLimitDTO,"/api/limits/create_premium_limit");
    }

//    todo, the HttpStatus for update is invalid. - why?  changed to OK -done
    @PostMapping("/update_single_premium_limit")
    public ResponseEntity<APIResponse> updateLimit(@RequestBody PremiumLimitDTO payload){
        List<PremiumLimitDTO> premiumLimitDTOList = limitsService.updateLimit(payload);
        return  buildResponseEntity(HttpStatus.OK,premiumLimitDTOList,"/api/limits/update");
    }

    @GetMapping("/get_all_limits")
    public ResponseEntity<APIResponse> getAllLimits(){
        return  buildResponseEntity(HttpStatus.OK,limitsService.getAllLimits(),"/api/limits/all");
    }

    @PostMapping("/delete_single_limit")
    public ResponseEntity<APIResponse> deleteLimit(@RequestBody PremiumLimitDTO payload){
        return  buildResponseEntity(HttpStatus.OK,limitsService.deleteLimit(payload),"/api/limits/delete");
    }

}
