package com.fiona.InsuranceType.Service;

import com.fiona.Exceptions.InsuranceTypeNotFoundException;
import com.fiona.InsuranceType.DTO.InsuranceTypeDTO;
import com.fiona.InsuranceType.Model.InsuranceType;
import com.fiona.InsuranceType.Repository.InsuranceTypeRepository;
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

    //Post
//    public Res createInsuranceType(InsuranceType insuranceType){
//        return   insuranceTypeRepository.save(insuranceType);
//    }
    public InsuranceType createInsuranceType(InsuranceType insuranceType){
        return  insuranceTypeRepository.save(insuranceType);
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


