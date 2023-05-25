package com.fiona.Services.Service;

import com.fiona.Exceptions.ResourceNotFoundException;
import com.fiona.ServiceProviders.Model.ServiceProviderDTO;
import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import com.fiona.Services.Model.ServicesDTO;
import com.fiona.Services.Model.ServicesModel;
import com.fiona.Services.Repository.ServiceRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicesService {
    private  ServiceRepository serviceRepository;
    private ModelMapper modelMapper;

    //create services
    @Transactional
    public ServicesDTO createNewService(ServicesDTO servicesDTORequest){
       ServicesModel services=serviceRepository.save((modelMapper.map(servicesDTORequest, ServicesModel.class)));
       return modelMapper.map(services, ServicesDTO.class);
    }

    //getAll
    public List<ServicesDTO> getAllServices(){
        List<ServicesDTO> servicesDTOList = serviceRepository.findAll()
                .stream()
                .map(service-> modelMapper.map(service, ServicesDTO.class))
                .toList();
             return servicesDTOList;
    }


    /**
     * @param servicesDTO
     * @return list of ServicesDTO
     */
    @Transactional
    public List<ServicesDTO> updateService(ServicesDTO servicesDTO){
        ServicesModel servicesModel = serviceRepository.findById(servicesDTO.getServiceId())
                .orElseThrow(() -> new ResourceNotFoundException("serviceProvider  with id " + servicesDTO.getServiceId() + " not found"));

        servicesModel.setName(servicesDTO.getName());
        return getAllServices();
    }

    @Transactional
    public List<ServicesDTO> deleteService(ServicesDTO servicesDTO){
        ServicesModel servicesModel = serviceRepository.findById(servicesDTO.getServiceId())
                .orElseThrow(()-> new ResourceNotFoundException("ServiceProvider with id " + servicesDTO.getServiceId() + " not found"));

        serviceRepository.delete(servicesModel);
        return getAllServices();
    }

}
