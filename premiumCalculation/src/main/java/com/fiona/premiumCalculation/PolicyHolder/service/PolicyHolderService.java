package com.fiona.premiumCalculation.PolicyHolder.service;


import com.fiona.DataDefinitionClient;
import com.fiona.premiumCalculation.Dependents.model.DependentsModel;
import com.fiona.premiumCalculation.PolicyHolder.model.PolicyHolderModel;
import com.fiona.premiumCalculation.PolicyHolder.payload.PolicyHolderDTO;
import com.fiona.premiumCalculation.PolicyHolder.repository.PolicyHolderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PolicyHolderService {
    private PolicyHolderRepository policyHolderRepository;
    private ModelMapper modelMapper;
    private DataDefinitionClient dataDefinitionClient;
    public PolicyHolderDTO registerAPolicyHolder(PolicyHolderDTO data){
        PolicyHolderModel policyHolderModel = modelMapper.map(data, PolicyHolderModel.class);

        for (DependentsModel dependent : data.getDependents()) {
            DependentsModel dependentEntity = modelMapper.map(dependent, DependentsModel.class);
            dependentEntity.setPolicyHolderId(policyHolderModel);
            policyHolderModel.getDependents().add(dependentEntity);
        }
        PolicyHolderModel policyHolderModelDbResponse = policyHolderRepository.save(policyHolderModel);
        return  modelMapper.map(policyHolderModelDbResponse,PolicyHolderDTO.class);
    }
    public List<PolicyHolderDTO> getAllPolicyHolder(){
        List<PolicyHolderModel> policyHolderModelList= policyHolderRepository.findAll();

        return policyHolderModelList.stream()
                .map(policyHolderModel -> {
                    PolicyHolderDTO policyHolderDTO = modelMapper.map(policyHolderModel, PolicyHolderDTO.class);
                    return policyHolderDTO;
                })
                .collect(Collectors.toList());
    }

    public List<PolicyHolderDTO> updatePolicyHolder(PolicyHolderDTO data){
        PolicyHolderModel policyHolderModel =findPolicyHolderById(data.getPolicyHolderId());
        policyHolderModel.setFirstName(data.getFirstName());
        policyHolderModel.setLastName(data.getLastName());
        policyHolderModel.setPhoneNumber(data.getPhoneNumber());
        policyHolderModel.setAge(data.getAge());
        return getAllPolicyHolder();
    }

    public List<PolicyHolderDTO> deletePolicyHolder(PolicyHolderDTO data){
        PolicyHolderModel policyHolderModel = findPolicyHolderById(data.getPolicyHolderId());
        policyHolderRepository.delete(policyHolderModel);
        return getAllPolicyHolder();
    }

    public List<?> getServiceProvidersServicesAndPremiums(){
        return dataDefinitionClient .getServicesProvidersAndLimits();
    }


    private PolicyHolderModel findPolicyHolderById(UUID policyHolderId) {
        return  policyHolderRepository.findById(policyHolderId)
//                TODO -Add exception handling
//                TODO - Add the method for this in the controller and make it return a DTO
                .orElseThrow();

    }



}
