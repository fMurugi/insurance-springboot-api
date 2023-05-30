package com.fiona.InsuranceType.Controller;

import com.fiona.Classes.APIResponse;
import com.fiona.InsuranceType.Model.InsuranceTypeDTO;
import com.fiona.InsuranceType.Repository.InsuranceTypeRepository;
import com.fiona.InsuranceType.Service.InsuranceTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.fiona.utilities.ApiResponseBuilder.buildResponseEntity;

@RestController
//        ! todo  USE CAMEL CASE TO DEFINE YOUR API ENDPOINTS, I.E (insurance_type)
//        ! todo  ADD THE VERSION OF THE ENDPOINT BEING USED. I.E (api/v1/insurance_type)
//        ! todo  USE THE FOLLOWING CONVENTIONS TO CREATE YOUR ENDPOINT URLS  (create_????, fetch_all_???, fetch_single_????, update_single_?? delete_single_???)

@RequestMapping("/api/insuranceType")
public class InsuranceTypeController {
    @Autowired
    private InsuranceTypeService insuranceTypeService;

    //        ! todo  UNUSED INJECTION.
    @Autowired
    private InsuranceTypeRepository insuranceTypeRepository;

    //        ! todo  UNUSED CONSTANT.
    public static final String SUCCESS = "Success";


    /**
     * @param insuranceTypeDTO
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<APIResponse> createInsuranceType(@RequestBody @Valid InsuranceTypeDTO insuranceTypeDTO){
        InsuranceTypeDTO insuranceTypeDTORes  = insuranceTypeService.createInsuranceType(insuranceTypeDTO);
        return buildResponseEntity(HttpStatus.CREATED,insuranceTypeDTORes,"created","/api/insuranceType/create");
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllInsuranceTypes(){
       List<InsuranceTypeDTO> insuranceTypeDTOList = insuranceTypeService.getAllInsuranceTypes();
      return buildResponseEntity(HttpStatus.OK,insuranceTypeDTOList,"returned all","/api/insuranceType/all");
    }

    @PostMapping("/update")
//! todo  the implementation of the vaiable payload is commendable.
    public ResponseEntity<APIResponse> updateInsuranceType(@RequestBody InsuranceTypeDTO payload){
        List<InsuranceTypeDTO> insuranceTypeDTOList =  insuranceTypeService.updateInsuranceType(payload);
        return  buildResponseEntity(HttpStatus.CREATED,insuranceTypeDTOList,"update successful","/api/insuranceType/update");
    }

    @PostMapping("/delete")
    public ResponseEntity<APIResponse> deleteInsuranceType(@RequestBody InsuranceTypeDTO payload){
        InsuranceTypeDTO insuranceTypeDTO = insuranceTypeService.deleteInsuranceType(payload);
        return  buildResponseEntity(HttpStatus.OK,insuranceTypeDTO,"deleted successfuly","api/insuranceType/delete");
    }


}
