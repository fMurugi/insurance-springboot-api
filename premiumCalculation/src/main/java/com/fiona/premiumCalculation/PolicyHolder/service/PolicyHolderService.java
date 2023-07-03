package com.fiona.premiumCalculation.PolicyHolder.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fiona.APIResponse;
import com.fiona.DataDefinitionClient;
import com.fiona.premiumCalculation.PolicyHolder.model.PolicyHolderModel;
import com.fiona.premiumCalculation.PolicyHolder.payload.PolicyHolderDTO;
import com.fiona.premiumCalculation.PolicyHolder.repository.PolicyHolderRepository;
import com.jayway.jsonpath.JsonPath;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalInt;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor

public class PolicyHolderService {
    private PolicyHolderRepository policyHolderRepository;
    private ModelMapper modelMapper;
    private DataDefinitionClient dataDefinitionClient;
    public PolicyHolderDTO registerAPolicyHolder(PolicyHolderDTO data){
        PolicyHolderModel policyHolderModel = modelMapper.map(data, PolicyHolderModel.class);


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

    public APIResponse<?> getServiceProvidersServicesAndPremiums() throws JsonProcessingException {
//        return dataDefinitionClient .getServicesProvidersAndLimits();
        APIResponse<?> response = dataDefinitionClient.getServicesProvidersAndLimits();

        return  response;
    }


    private PolicyHolderModel findPolicyHolderById(UUID policyHolderId) {
        return  policyHolderRepository.findById(policyHolderId)
//                TODO -Add exception handling
//                TODO - Add the method for this in the controller and make it return a DTO
                .orElseThrow();

    }



}
