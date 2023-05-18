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

@Service
public class InsuranceTypeService {

    @Autowired
    private InsuranceTypeRepository insuranceTypeRepository;
    @Autowired
    private ModelMapper modelMapper;

    //Post
//    public Res createInsuranceType(InsuranceType insuranceType){
//        return   insuranceTypeRepository.save(insuranceType);
//    }
    public InsuranceTypeDTO createInsuranceType(InsuranceTypeDTO insuranceTypeDTORequest){
        //convert dto to entity
        InsuranceType insuranceType = modelMapper.map(insuranceTypeDTORequest,InsuranceType.class);

        InsuranceType insuranceTypeResults = insuranceTypeRepository.save(insuranceType);

        //convert entity back to Dto

        InsuranceTypeDTO insuranceTypeDTO = modelMapper.map(insuranceTypeResults,InsuranceTypeDTO.class);

        return  insuranceTypeDTO;

    }

    //get all
    public List<InsuranceType> getAllInsuranceTypes(){
        return insuranceTypeRepository.findAll();
    }

    public InsuranceType updateInsuranceType(InsuranceType insuranceTypeReq){

        return insuranceTypeRepository.save(insuranceTypeReq);
    }
}

    //  update


