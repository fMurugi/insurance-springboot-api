package com.fiona.ServiceProviders.Service;

import com.fiona.Exceptions.ResourceNotFoundException;
import com.fiona.ServiceProviders.Model.ServiceProviderDTO;
import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import com.fiona.ServiceProviders.Repository.ServiceProvidersRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ServiceProviderService {
    private ModelMapper modelMapper;
    private ServiceProvidersRepository serviceProvidersRepository;

    public ServiceProviderDTO createNewServiceProvider(ServiceProviderDTO data){
        ServiceProviderModel serviceProviderModel = modelMapper.map(data, ServiceProviderModel.class);
        ServiceProviderModel serviceProviderDbResponse = serviceProvidersRepository.save(serviceProviderModel);
        return  modelMapper.map(serviceProviderDbResponse,ServiceProviderDTO.class);
    }
//    TODO UNUSED CODE.-done
    @Transactional
    public List<ServiceProviderDTO> getAllServiceProviders(){
        List<ServiceProviderModel> serviceProvidersList= serviceProvidersRepository.findAll();

        List<ServiceProviderDTO> serviceProviderDtoList = serviceProvidersList.stream()
                .map(serviceProvider -> modelMapper.map(serviceProvider, ServiceProviderDTO.class))
                .collect(Collectors.toList());
        return serviceProviderDtoList;
    }

    @Transactional
    public List<ServiceProviderDTO> updateServiceProvider(ServiceProviderDTO data){
        ServiceProviderModel serviceProvider = findServiceProviderById(data.getServiceProviderId());
        serviceProvider.setName(data.getName());
        serviceProvider.setLocation(data.getLocation());
        return getAllServiceProviders();
    }

    public List<ServiceProviderDTO> deleteServiceProvider(ServiceProviderDTO data){
        ServiceProviderModel serviceProvider = findServiceProviderById(data.getServiceProviderId());
        serviceProvidersRepository.delete(serviceProvider);
        return getAllServiceProviders();
    }

    public ServiceProviderModel findServiceProviderById(UUID id){
        return  serviceProvidersRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("service provider with id " + id + "not found"));
    }


    public ServiceProviderDTO getServiceProviderByName(ServiceProviderDTO data) {
        return  modelMapper.map(serviceProvidersRepository.findByName(data.getName()),ServiceProviderDTO.class);
    }
}
