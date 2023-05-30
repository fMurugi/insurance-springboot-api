package com.fiona.Limits.service;

import com.fiona.Exceptions.ResourceNotFoundException;
import com.fiona.Limits.model.PremiumLimit;
import com.fiona.Limits.model.PremiumLimitDTO;
import com.fiona.Limits.repository.PremiumLimitRepository;
import com.fiona.ServiceProviders.Model.ServiceProviderDTO;
import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import com.fiona.ServiceProviders.Repository.ServiceProvidersRepository;
import com.fiona.Services.Model.ServicesModel;
import com.fiona.Services.Repository.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LimitsService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PremiumLimitRepository premiumLimitRepository;

//    todo, on doing a post to add , kindly always return all the results not the individual one.
    public PremiumLimitDTO createNewPremiumLimit(PremiumLimitDTO premiumLimitDTO){
        PremiumLimit premiumLimit = modelMapper.map(premiumLimitDTO, PremiumLimit.class);

         premiumLimit = premiumLimitRepository.save(premiumLimit);
        return  modelMapper.map(premiumLimit,PremiumLimitDTO.class);
    }

    public List<PremiumLimitDTO> getAllLimits(){
        List<PremiumLimit> premiumLimitList= premiumLimitRepository.findAll();

        List<PremiumLimitDTO> premiumLimitDTOList = premiumLimitList.stream()
                .map(limit -> modelMapper.map(limit, PremiumLimitDTO.class))
                .collect(Collectors.toList());
        return premiumLimitDTOList;
    }

    public List<PremiumLimitDTO> updateLimit(PremiumLimitDTO premiumLimitDTO){
        PremiumLimit premiumLimit = premiumLimitRepository.findById(premiumLimitDTO.getPremiumLimitId())
                .orElseThrow(() -> new ResourceNotFoundException("premium limit  with id " + premiumLimitDTO.getPremiumLimitId() + " not found"));

        premiumLimit.setMinAge(premiumLimitDTO.getMinAge());
        premiumLimit.setMaxAge(premiumLimitDTO.getMaxAge());
        return getAllLimits();
    }

    public List<PremiumLimitDTO> deleteLimit(PremiumLimitDTO premiumLimitDTO){
        PremiumLimit premiumLimit = premiumLimitRepository.findById(premiumLimitDTO.getPremiumLimitId())
                .orElseThrow(()-> new ResourceNotFoundException("Premium limit  with id " + premiumLimitDTO.getPremiumLimitId() + " not found"));

        premiumLimitRepository.delete(premiumLimit);
        return getAllLimits();
    }
}
