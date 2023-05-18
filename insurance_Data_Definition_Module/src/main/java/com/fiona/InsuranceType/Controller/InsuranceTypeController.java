package com.fiona.InsuranceType.Controller;

import com.fiona.InsuranceType.DTO.APIResponse;
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
    @PostMapping("/create")
    public ResponseEntity<APIResponse> createInsuranceType(@RequestBody @Valid InsuranceTypeDTO insuranceTypeDTO){

        InsuranceTypeDTO insuranceTypeDTORes  = insuranceTypeService.createInsuranceType(insuranceTypeDTO);

        APIResponse<InsuranceTypeDTO> responseDTO = APIResponse
                .<InsuranceTypeDTO>builder()
                .status(SUCCESS)
                .body(insuranceTypeDTORes)
                .build();
        return  new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<APIResponse>  getAllInsuranceTypes(){
       List<InsuranceTypeDTO> insuranceTypeDTOList = insuranceTypeService.getAllInsuranceTypes();

       APIResponse<List<InsuranceTypeDTO>> responseDTO = APIResponse
               .<List<InsuranceTypeDTO>>builder()
               .status(SUCCESS)
               .body( insuranceTypeDTOList)
               .build();
       return  new ResponseEntity<>(responseDTO,HttpStatus.OK);


    }

//    @GetMapping("/getAll")
//    public List<InsuranceType> getAllInsuranceTypesWithUUID(){
//         List<InsuranceType> insuranceTypeList = insuranceTypeRepository.findAll();
//         return  insuranceTypeList;
//    }

    //update

//    @PostMapping("/update")
//    public ResponseEntity<InsuranceTypeDTO> updateInsuranceType(@RequestBody InsuranceType payload){
//        UUID id = payload.getInsuranceTypeId();
//
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ id);
//
//        InsuranceType insuranceTypeReq = modelMapper.map(payload, InsuranceType.class);
//
//        // Check if the resource exists
//
//        InsuranceType insuranceType = insuranceTypeRepository.findById(id)
//                .orElseThrow(()-> new InsuranceTypeNotFoundException("insuranceType with id" + id + " NOT FOUND"));
//
//        insuranceType.setName(insuranceTypeReq.getName());
//        insuranceType.setDescription(insuranceTypeReq.getDescription());
//
//        //save the request to the db as an entity
//       InsuranceType updateInsuranceType= insuranceTypeService.updateInsuranceType(insuranceType);
//
//
//        //convert entity to DTO
//        InsuranceTypeDTO insuranceTypeResPonse = modelMapper.map(updateInsuranceType,InsuranceTypeDTO.class);
//
//        return  new ResponseEntity<>(insuranceTypeResPonse, HttpStatus.CREATED);
//
//
//    }


}
