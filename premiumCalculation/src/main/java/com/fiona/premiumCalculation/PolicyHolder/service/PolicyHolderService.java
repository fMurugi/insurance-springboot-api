package com.fiona.premiumCalculation.PolicyHolder.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiona.APIResponse;
import com.fiona.DataDefinitionClient;

import com.fiona.premiumCalculation.Classes.DependentPremiumLimit;
import com.fiona.premiumCalculation.Classes.PremiumLimit;
import com.fiona.premiumCalculation.Classes.PremiumsQuotation;
import com.fiona.premiumCalculation.Classes.ServiceProviderServicesPremiums;
import com.fiona.premiumCalculation.Dependents.model.DependentsModel;
import com.fiona.premiumCalculation.Dependents.payload.DependentsDTO;
import com.fiona.premiumCalculation.PolicyHolder.model.PolicyHolderModel;
import com.fiona.premiumCalculation.PolicyHolder.payload.PolicyHolderDTO;
import com.fiona.premiumCalculation.PolicyHolder.repository.PolicyHolderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.io.IOException;
import java.util.*;
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


private PolicyHolderModel findPolicyHolderById(UUID policyHolderId) {
    return  policyHolderRepository.findById(policyHolderId)
//                TODO -Add exception handling
//                TODO - Add the method for this in the controller and make it return a DTO
            .orElseThrow();

}

    public List<PremiumsQuotation> getServiceProvidersServicesAndPremiums(PolicyHolderDTO policyHolder) throws JsonProcessingException {
        APIResponse<?> response = dataDefinitionClient.getServicesProvidersAndLimits();
        List<ServiceProviderServicesPremiums> serviceProvidersList = new ArrayList<>();
        if (response != null && response.getBody() != null && response.getBody() instanceof List<?>) {
            ObjectMapper objectMapper = new ObjectMapper();
            serviceProvidersList = objectMapper.convertValue(response.getBody(), new TypeReference<List<ServiceProviderServicesPremiums>>() {});
        } else {
            System.out.println("No data found in the response.");
        }
        List<PremiumsQuotation> premiumLimitsSummaries = calculatePremiumLimitsForPolicyHolderAndDependents(policyHolder, serviceProvidersList);
        return premiumLimitsSummaries;
    }




    public int calculatePremiumLimitForPolicyHolder(ServiceProviderServicesPremiums serviceProvider, PolicyHolderDTO policyHolder) {
        int age = policyHolder.getAge();
        for (PremiumLimit premiumLimit : serviceProvider.getPremiumLimit()) {
            if (age >= premiumLimit.getMinimumAge() && age <= premiumLimit.getMaximumAge()) {
                return premiumLimit.getPremium();
            }
        }
        return 0;
    }

    public int calculatePremiumLimitForDependent(ServiceProviderServicesPremiums serviceProvider, DependentsDTO dependent) {
        int age = dependent.getAge();
        for (PremiumLimit premiumLimit : serviceProvider.getPremiumLimit()) {
            if (age >= premiumLimit.getMinimumAge() && age <= premiumLimit.getMaximumAge()) {
                return premiumLimit.getPremium();
            }
        }
        return 0;
    }


    public List<PremiumsQuotation> calculatePremiumLimitsForPolicyHolderAndDependents(PolicyHolderDTO policyHolder, List<ServiceProviderServicesPremiums> serviceProvidersList) {
        List<PremiumsQuotation> premiumsQuotations = new ArrayList<>();

        for (ServiceProviderServicesPremiums serviceProvider : serviceProvidersList) {
            PremiumsQuotation premiumsQuotation = new PremiumsQuotation();
            premiumsQuotation.setServiceProviderName(serviceProvider.getName());

            // Calculate premium limit for policy holder
            int premiumLimitForPolicyHolder = calculatePremiumLimitForPolicyHolder(serviceProvider, policyHolder);
            if (policyHolder.getHasChronicDisease()) {
                premiumLimitForPolicyHolder *= 2; // Double the premium limit
            }
            premiumsQuotation.setPolicyHolderPremiumLimit(premiumLimitForPolicyHolder);

            List<DependentsDTO> dependents = policyHolder.getDependents();
            List<DependentPremiumLimit> dependentPremiumLimits = new ArrayList<>();

            // Calculate premium limits for dependents
            for (DependentsDTO dependent : dependents) {
                int premiumLimitForDependent = calculatePremiumLimitForDependent(serviceProvider, dependent);
                if (dependent.getHasChronicDisease()) {
                    premiumLimitForDependent *= 2; // Double the premium limit
                }
                DependentPremiumLimit dependentPremiumLimit = new DependentPremiumLimit(dependent.getFirstName(), premiumLimitForDependent);
                dependentPremiumLimits.add(dependentPremiumLimit);
            }

            premiumsQuotation.setDependents(dependentPremiumLimits);
            premiumsQuotations.add(premiumsQuotation);
        }
        return premiumsQuotations;
    }
}
