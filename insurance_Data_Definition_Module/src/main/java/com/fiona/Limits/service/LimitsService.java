package com.fiona.Limits.service;

import com.fiona.Exceptions.ResourceNotFoundException;
import com.fiona.Limits.model.PremiumLimit;
import com.fiona.Limits.Payload.PremiumLimitDTO;
import com.fiona.Limits.repository.PremiumLimitRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LimitsService {
    private ModelMapper modelMapper;
    private PremiumLimitRepository premiumLimitRepository;

//    todo, on doing a post to add , kindly always return all the results not the individual one. -done
    public List<PremiumLimitDTO> createNewPremiumLimit(PremiumLimitDTO premiumLimitDTO){
        PremiumLimit premiumLimit = modelMapper.map(premiumLimitDTO, PremiumLimit.class);
         premiumLimit = premiumLimitRepository.save(premiumLimit);
        return  getAllLimits();
    }

    public List<PremiumLimitDTO> getAllLimits(){
        List<PremiumLimit> premiumLimitList= premiumLimitRepository.findAll();
        List<PremiumLimitDTO> premiumLimitDTOList = premiumLimitList.stream()
                .map(limit -> modelMapper.map(limit, PremiumLimitDTO.class))
                .collect(Collectors.toList());
        return premiumLimitDTOList;
    }

    public List<PremiumLimitDTO> updateLimit(PremiumLimitDTO data){
        PremiumLimit premiumLimit = findPremiumLimitById(data.getPremiumLimitId());
        premiumLimit.setMaximumAge(data.getMinimumAge());
        premiumLimit.setMaximumAge(data.getMaximumAge());
        return getAllLimits();
    }

    public List<PremiumLimitDTO> deleteLimit(PremiumLimitDTO data){
        PremiumLimit premiumLimit = findPremiumLimitById(data.getPremiumLimitId());
        premiumLimitRepository.delete(premiumLimit);
        return getAllLimits();
    }

    public PremiumLimit findPremiumLimitById(UUID id){
        return  premiumLimitRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Premium limit  with id " + id + " not found"));
    }
}
