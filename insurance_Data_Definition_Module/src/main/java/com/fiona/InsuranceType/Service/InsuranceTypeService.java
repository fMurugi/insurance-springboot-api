package com.fiona.InsuranceType.Service;

import com.fiona.Exceptions.ResourceNotFoundException;
import com.fiona.InsuranceType.Model.InsuranceTypeDTO;
import com.fiona.InsuranceType.Model.InsuranceType;
import com.fiona.InsuranceType.Repository.InsuranceTypeRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    //! todo  Use @ transactional pattern to run updates. -done
//! todo  send data to the services in the form of a variable called data, so that we can know where the variable was initially added. -done
    @Transactional
    public List<InsuranceTypeDTO> updateInsuranceType(InsuranceTypeDTO data){

//         todo CODE DUPLICATION, KINDLY REFACTOR AS IT IS SIMILAR TO THE CODE IN THE DELETE SECTION WHEN FINDING DATA BY ID. -done
        //         todo  YOU CAN CREATE A METHOD THAT JUST FETCHES THE DATA GIVEN ID. -done
        
        InsuranceType insuranceType = findInsuranceTypeById(data.getInsuranceTypeId());
        insuranceType.setName(data.getName());
        insuranceType.setDescription(data.getDescription());
        return getAllInsuranceTypes();
    }
    public InsuranceTypeDTO deleteInsuranceType(InsuranceTypeDTO data){
        InsuranceType insuranceType = findInsuranceTypeById(data.getInsuranceTypeId());
         insuranceTypeRepository.delete(insuranceType);
        return modelMapper.map(insuranceType, InsuranceTypeDTO.class);
    }

    public InsuranceType findInsuranceTypeById(UUID id){
           return insuranceTypeRepository.findById(id)
                   .orElseThrow(()-> new ResourceNotFoundException("insuranceType with id " + id + "NOT FOUND"));

    }

}



