package com.fiona.HospitalLevels.service;

import com.fiona.Exceptions.ResourceNotFoundException;
import com.fiona.HospitalLevels.model.HospitalLevels;
import com.fiona.HospitalLevels.payload.HospitalLevelDTO;
import com.fiona.HospitalLevels.repository.HospitalLevelsRepository;
import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import com.fiona.ServiceProviders.Payload.ServiceProviderDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HospitalLevelService {
    private HospitalLevelsRepository hospitalLevelsRepository;
    private final ModelMapper modelMapper;

    public List<HospitalLevelDTO> createNewHospitalLevel(HospitalLevelDTO data){
        HospitalLevels hospitalLevels =  modelMapper.map(data,HospitalLevels.class);
        HospitalLevels hospitalLevelsDbRse = hospitalLevelsRepository.save(hospitalLevels);
        return  getAllHospitalLevels();
    }

    public List<HospitalLevelDTO> getAllHospitalLevels(){
        List<HospitalLevels> hospitalLevels= hospitalLevelsRepository.findAll();

        return hospitalLevels.stream()
                .map(hospitalLevel -> {
                    HospitalLevelDTO hospitalLevelDTO = modelMapper.map(hospitalLevel, HospitalLevelDTO.class);
                    return hospitalLevelDTO;
                })
                .collect(Collectors.toList());
    }
    @Transactional
    public List<HospitalLevelDTO> updateHospitalLevels(HospitalLevelDTO data){
        HospitalLevels hospitalLevels =findHospitalLevelById(data.getLevelId());
        hospitalLevels.setName(data.getName());
        return getAllHospitalLevels();
    }

    public List<HospitalLevelDTO> deleteHospitalLevel(HospitalLevelDTO data){
        HospitalLevels hospitalLevels = findHospitalLevelById(data.getLevelId());
        hospitalLevelsRepository.delete(hospitalLevels);
        return getAllHospitalLevels();
    }

    public HospitalLevels  findHospitalLevelById(UUID id){
        return hospitalLevelsRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Service Provider does not exist"));

    }
}
