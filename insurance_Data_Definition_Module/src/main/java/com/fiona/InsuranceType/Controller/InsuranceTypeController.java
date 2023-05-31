package com.fiona.InsuranceType.Controller;

import com.fiona.Classes.APIResponse;
import com.fiona.InsuranceType.Model.InsuranceType;
import com.fiona.InsuranceType.Model.InsuranceTypeDTO;
import com.fiona.InsuranceType.Service.InsuranceTypeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fiona.utilities.ApiResponseBuilder.buildResponseEntity;

@RestController
//        ! todo  USE CAMEL CASE TO DEFINE YOUR API ENDPOINTS, I.E (insurance_type) - Done
//        ! todo  ADD THE VERSION OF THE ENDPOINT BEING USED. I.E (api/v1/insurance_type) -Done
//        ! todo  USE THE FOLLOWING CONVENTIONS TO CREATE YOUR ENDPOINT URLS  (create_????, fetch_all_???, fetch_single_????, update_single_?? delete_single_???) - Done

@RequestMapping("/api/v1/insurance_type")
@AllArgsConstructor
public class InsuranceTypeController {
    private InsuranceTypeService insuranceTypeService;

    //        ! todo  UNUSED INJECTION. -Done

    //        ! todo  UNUSED CONSTANT. -Done
    /**
     * @param insuranceTypeDTO
     * @return
     */
    // ! todo How do I parametrize the following methods?
    @PostMapping("/create_insurance_type")
    public ResponseEntity<APIResponse> createInsuranceType(@RequestBody @Valid InsuranceTypeDTO insuranceTypeDTO){
        String httpStatus = "created";
        String requestUrl = "/api/insuranceType/create";
        InsuranceTypeDTO insuranceTypeDTORes = insuranceTypeService.createInsuranceType(insuranceTypeDTO);
        return buildResponseEntity(HttpStatus.CREATED, insuranceTypeDTORes, httpStatus, requestUrl);
    }


    @GetMapping("/fetch_all_insurance_types")
    public ResponseEntity<APIResponse> getAllInsuranceTypes(){
       List<InsuranceTypeDTO> insuranceTypeDTOList = insuranceTypeService.getAllInsuranceTypes();
      return buildResponseEntity(HttpStatus.OK,insuranceTypeDTOList,"returned all","/api/insuranceType/all");
    }
    @GetMapping("/fetch_all_insurance_types/{offset}/{pageSize}")
    public ResponseEntity<APIResponse> getPaginatedInsuranceType(@PathVariable int offset,@PathVariable int pageSize){
        Page<InsuranceType> insuranceTypeDTOList = insuranceTypeService.paginate(offset,pageSize);
        return buildResponseEntity(HttpStatus.OK,insuranceTypeDTOList,"returned all","/api/insuranceType/all");
    }

    @PostMapping("/update_single_insurance_types")
//! todo  the implementation of the vaiable payload is commendable. -Done
    public ResponseEntity<APIResponse> updateInsuranceType(@RequestBody InsuranceTypeDTO payload){
        List<InsuranceTypeDTO> insuranceTypeDTOList =  insuranceTypeService.updateInsuranceType(payload);
        return  buildResponseEntity(HttpStatus.CREATED,insuranceTypeDTOList,"update successful","/api/insuranceType/update");
    }

    @PostMapping("/delete_single_insurance_type")
    public ResponseEntity<APIResponse> deleteInsuranceType(@RequestBody InsuranceTypeDTO payload){
        InsuranceTypeDTO insuranceTypeDTO = insuranceTypeService.deleteInsuranceType(payload);
        return  buildResponseEntity(HttpStatus.OK,insuranceTypeDTO,"deleted successfully","api/insuranceType/delete");
    }


}
