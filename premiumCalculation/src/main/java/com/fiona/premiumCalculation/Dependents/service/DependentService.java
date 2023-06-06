package com.fiona.premiumCalculation.Dependents.service;

import com.fiona.premiumCalculation.Dependents.model.DependentsModel;
import com.fiona.premiumCalculation.Dependents.payload.DependentsDTO;
import com.fiona.premiumCalculation.Dependents.repository.DependentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DependentService {
    private final DependentRepository dependentRepository;
    private ModelMapper modelMapper;

    public DependentsDTO registerDependent(DependentsDTO data){
        DependentsModel dependentsModel = modelMapper.map(data, DependentsModel.class);
        DependentsModel dependentDbRes = dependentRepository.save(dependentsModel);
        return  modelMapper.map(dependentDbRes,DependentsDTO.class);
    }

    public List<DependentsDTO> getAllDependents(){
        List<DependentsModel> dependentsModelList= dependentRepository.findAll();

        return dependentsModelList.stream()
                .map(dependentsModel -> {
                    DependentsDTO dependentsDTO = modelMapper.map(dependentsModel, DependentsDTO.class);
                    return dependentsDTO;
                })
                .collect(Collectors.toList());
    }

    public List<DependentsDTO> updateDependents(DependentsDTO data){
        DependentsModel dependentsModel =findDependentById(data.getDependentId());
        dependentsModel.setFirstName(data.getFirstName());
        dependentsModel.setLastName(data.getLastName());
        dependentsModel.setAge(data.getAge());
        return getAllDependents();
    }

    public List<DependentsDTO> deleteDependent(DependentsDTO data){
        DependentsModel dependentsModel = findDependentById(data.getPolicyHolderId());
        dependentRepository.delete(dependentsModel);
        return getAllDependents();
    }

//     -TODO add method for this in the controller
//     -TODO add exception handling
    private DependentsModel findDependentById(UUID dependentId) {
        return dependentRepository.findById(dependentId)
                .orElseThrow();
    }

}
