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

@RestController
@RequestMapping("/api/insuranceType")
public class InsuranceTypeController {
    @Autowired
    private InsuranceTypeService insuranceTypeService;
    @Autowired
    private InsuranceTypeRepository insuranceTypeRepository;
    public static final String SUCCESS = "Success";

    private <T> ResponseEntity<APIResponse> buildResponseEntity(HttpStatus status, T body,String message,String path) {
        APIResponse<T> responseDTO = APIResponse.<T>builder()
                .body(body)
                .timeStamp(LocalDateTime.now())
                .message(message)
                .path(path)
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
        return buildResponseEntity(HttpStatus.CREATED,insuranceTypeDTORes,"created","/api/insuranceType/create");
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllInsuranceTypes(){
       List<InsuranceTypeDTO> insuranceTypeDTOList = insuranceTypeService.getAllInsuranceTypes();
      return buildResponseEntity(HttpStatus.OK,insuranceTypeDTOList,"returned all","/api/insuranceType/all");
    }

    @PostMapping("/update")
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
