package com.fiona.InsuranceType.Controller;

import com.fiona.Exceptions.APIResponse;
import com.fiona.InsuranceType.DTO.InsuranceTypeDTO;
import com.fiona.InsuranceType.Repository.InsuranceTypeRepository;
import com.fiona.InsuranceType.Service.InsuranceTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insuranceType")
public class InsuranceTypeController {

    @Autowired
    private InsuranceTypeService insuranceTypeService;

    @Autowired
    private InsuranceTypeRepository insuranceTypeRepository;

    public static final String SUCCESS = "Success";
    private <T> ResponseEntity<APIResponse> buildResponseEntity(HttpStatus status, T body) {
        APIResponse<T> responseDTO = APIResponse.<T>builder()
                .status(SUCCESS)
                .body(body)
                .build();
        return new ResponseEntity<>(responseDTO, status);
    }

    /**
     * @param insuranceTypeDTO
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<APIResponse> createInsuranceType(@RequestBody @Valid InsuranceTypeDTO insuranceTypeDTO){

        InsuranceTypeDTO insuranceTypeDTORes  = insuranceTypeService.createInsuranceType(insuranceTypeDTO);


        return buildResponseEntity(HttpStatus.CREATED,insuranceTypeDTORes);
    }


    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllInsuranceTypes(){
       List<InsuranceTypeDTO> insuranceTypeDTOList = insuranceTypeService.getAllInsuranceTypes();

      return buildResponseEntity(HttpStatus.OK,insuranceTypeDTOList);


    }

    //update
    @PostMapping("/update")
    public ResponseEntity<APIResponse> updateInsuranceType(@RequestBody InsuranceTypeDTO payload){
        InsuranceTypeDTO insuranceTypeDTORes =  insuranceTypeService.updateInsuranceType(payload);

        return  buildResponseEntity(HttpStatus.CREATED,insuranceTypeDTORes);
    }


}
