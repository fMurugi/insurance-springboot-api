package com.fiona.InsuranceType.Service;

import com.fiona.Exceptions.ResourceNotFoundException;
import com.fiona.InsuranceType.Model.InsuranceTypeDTO;
import com.fiona.InsuranceType.Model.InsuranceType;
import com.fiona.InsuranceType.Repository.InsuranceTypeRepository;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceTypeService {
    @Autowired
    private InsuranceTypeRepository insuranceTypeRepository;
    @Autowired
    private ModelMapper modelMapper;

       public InsuranceTypeDTO createInsuranceType(InsuranceTypeDTO insuranceTypeDTORequest) {
        InsuranceType insuranceType = modelMapper.map(insuranceTypeDTORequest, InsuranceType.class);
        InsuranceType insuranceTypeResults = insuranceTypeRepository.save(insuranceType);
        return modelMapper.map(insuranceTypeResults, InsuranceTypeDTO.class);
    }

    //! todo  all the fetch apis should implement pagination to them, add upto 50 records per fetch to improve performance in the case of a large dataset.
    //get all
    public List<InsuranceTypeDTO> getAllInsuranceTypes(){
         List<InsuranceType> insuranceTypeList= insuranceTypeRepository.findAll();

        List<InsuranceTypeDTO> insuranceTypeDTOList = insuranceTypeList.stream()
                     .map(insuranceType -> modelMapper.map(insuranceType, InsuranceTypeDTO.class))
                     .collect(Collectors.toList());
         return insuranceTypeDTOList;
    }

    //! todo  Use @ transactional pattern to run updates.
//! todo  send data to the services in the form of a variable called data, so that we can know where the variable was initially added.
    public List<InsuranceTypeDTO> updateInsuranceType(InsuranceTypeDTO insuranceTypeDTOReq){

//         todo CODE DUPLICATION, KINDLY REFACTOR AS IT IS SIMILAR TO THE CODE IN THE DELETE SECTION WHEN FINDING DATA BY ID.
        //         todo  YOU CAN CREATE A METHOD THAT JUST FETCHES THE DATA GIVEN ID.
        
        InsuranceType insuranceType = insuranceTypeRepository.findById(insuranceTypeDTOReq.getInsuranceTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("insuranceType with id " + insuranceTypeDTOReq.getInsuranceTypeId() + " not found"));

        insuranceType.setName(insuranceTypeDTOReq.getName());
        insuranceType.setDescription(insuranceTypeDTOReq.getDescription());
        return getAllInsuranceTypes();
    }
    public InsuranceTypeDTO deleteInsuranceType(InsuranceTypeDTO insuranceTypeDTO){
        InsuranceType insuranceType = insuranceTypeRepository.findById(insuranceTypeDTO.getInsuranceTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("insuranceType with id " + insuranceTypeDTO.getInsuranceTypeId() + " not found"));
         insuranceTypeRepository.delete(insuranceType);
        return modelMapper.map(insuranceType, InsuranceTypeDTO.class);
    }

}



