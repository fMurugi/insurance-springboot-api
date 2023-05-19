package com.fiona.InsuranceType.Service;

import com.fiona.Exceptions.InsuranceTypeNotFoundException;
import com.fiona.InsuranceType.DTO.InsuranceTypeDTO;
import com.fiona.InsuranceType.Model.InsuranceType;
import com.fiona.InsuranceType.Repository.InsuranceTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InsuranceTypeService {

    @Autowired
    private InsuranceTypeRepository insuranceTypeRepository;
    @Autowired
    private ModelMapper modelMapper;


    public InsuranceTypeDTO createInsuranceType(InsuranceTypeDTO insuranceTypeDTORequest){
        //convert dto to entity
        InsuranceType insuranceType = modelMapper.map(insuranceTypeDTORequest,InsuranceType.class);

        InsuranceType insuranceTypeResults = insuranceTypeRepository.save(insuranceType);

        //convert entity back to Dto

        InsuranceTypeDTO insuranceTypeDTO = modelMapper.map(insuranceTypeResults,InsuranceTypeDTO.class);

        return  insuranceTypeDTO;

    }

    //get all
    public List<InsuranceTypeDTO> getAllInsuranceTypes(){
        List<InsuranceTypeDTO> insuranceTypeDTOList = null;
         List<InsuranceType> insuranceTypeList= insuranceTypeRepository.findAll();

         if(!insuranceTypeList.isEmpty()){
             insuranceTypeDTOList = insuranceTypeList.stream()
                     .map(insuranceType -> modelMapper.map(insuranceType, InsuranceTypeDTO.class))
                     .collect(Collectors.toList());
         }else {
             insuranceTypeDTOList  = Collections.emptyList();
         }

         return insuranceTypeDTOList;

    }

    public InsuranceTypeDTO updateInsuranceType(InsuranceTypeDTO insuranceTypeDTOReq){
            // get the id
        UUID id  =  insuranceTypeDTOReq.getInsuranceTypeId();

        InsuranceType insuranceType = modelMapper.map(insuranceTypeDTOReq,InsuranceType.class);

        InsuranceType insuranceTypeDbRes = insuranceTypeRepository.findById(id)
                .orElseThrow(()-> new InsuranceTypeNotFoundException("insuranceType with id" + id + " NOT FOUND"));

        insuranceType.setName(insuranceTypeDTOReq.getName());
        insuranceType.setDescription(insuranceTypeDTOReq.getDescription());

        InsuranceType updatedInsuranceType = insuranceTypeRepository.save(insuranceType);

        //change entity to dto
        InsuranceTypeDTO insuranceTypeDTORes = modelMapper.map(insuranceType,InsuranceTypeDTO.class);


        return insuranceTypeDTORes;
    }
}

    //  update


