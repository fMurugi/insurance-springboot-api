package com.fiona.InsuranceType.Controller;

import com.fiona.Exceptions.InsuranceTypeNotFoundException;
import com.fiona.InsuranceType.DTO.InsuranceTypeDTO;
import com.fiona.InsuranceType.Model.InsuranceType;
import com.fiona.InsuranceType.Repository.InsuranceTypeRepository;
import com.fiona.InsuranceType.Service.InsuranceTypeService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/insuranceType")
public class InsuranceTypeController {

    @Autowired
    private InsuranceTypeService insuranceTypeService;

    @Autowired
    private InsuranceTypeRepository insuranceTypeRepository;

    @PostMapping("/create")
    public ResponseEntity<InsuranceTypeDTO> createInsuranceType(@RequestBody @Valid InsuranceTypeDTO insuranceTypeDTO){

        InsuranceTypeDTO insuranceTypeDTORes  = insuranceTypeService.createInsuranceType(insuranceTypeDTO);

        return  new ResponseEntity<>(insuranceTypeDTORes, HttpStatus.CREATED);
    }
//    @GetMapping("/all")
//    public Object  getAllInsuranceTypes(){
//       List<InsuranceTypeDTO> insuranceTypeDTOList = insuranceTypeService.getAllInsuranceTypes().stream().map(insuranceType -> modelMapper.map(insuranceType,InsuranceTypeDTO.class))
//               .collect(Collectors.toList());
//       return insuranceTypeDTOList;
//
//
//    }

    @GetMapping("/getAll")
    public List<InsuranceType> getAllInsuranceTypesWithUUID(){
         List<InsuranceType> insuranceTypeList = insuranceTypeRepository.findAll();
         return  insuranceTypeList;
    }

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
