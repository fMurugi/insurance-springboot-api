package com.fiona.Services.Service;

import com.fiona.Exceptions.ResourceNotFoundException;
import com.fiona.Services.payload.ServicesDTO;
import com.fiona.Services.Model.ServicesModel;
import com.fiona.Services.Repository.ServiceRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ServicesService {
    private  ServiceRepository serviceRepository;
    private ModelMapper modelMapper;

    @Transactional
    public ServicesDTO createNewService(ServicesDTO servicesDTORequest){
       ServicesModel services=serviceRepository.save((modelMapper.map(servicesDTORequest, ServicesModel.class)));
       return modelMapper.map(services, ServicesDTO.class);
    }

    public List<ServicesDTO> getAllServices(){
        List<ServicesDTO> servicesDTOList = serviceRepository.findAll()
                .stream()
                .map(service-> modelMapper.map(service, ServicesDTO.class))
                .toList();
             return servicesDTOList;
    }


    /**
     * @param data
     * @return list of ServicesDTO
     */
    @Transactional
    public List<ServicesDTO> updateService(ServicesDTO data){
        ServicesModel servicesModel = findServiceById(data.getServiceId());
        servicesModel.setName(data.getName());
        return getAllServices();
    }

    @Transactional
    public List<ServicesDTO> deleteService(ServicesDTO data){
        ServicesModel servicesModel = findServiceById(data.getServiceId());
        serviceRepository.delete(servicesModel);
        return getAllServices();
    }

    public ServicesModel findServiceById(UUID id){
        return serviceRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Service with id "+ id+ "NOT FOUND"));
    }

}
