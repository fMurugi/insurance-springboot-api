package com.fiona.ServiceProviders.Service;

import com.fiona.Exceptions.ResourceNotFoundException;
import com.fiona.InsuranceType.Model.InsuranceType;
import com.fiona.InsuranceType.Model.InsuranceTypeDTO;
import com.fiona.ServiceProviders.Model.ServiceProviderDTO;
import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import com.fiona.ServiceProviders.Repository.ServiceProvidersRepository;
import com.fiona.Services.Model.ServicesDTO;
import com.fiona.Services.Model.ServicesModel;
import com.fiona.Services.Repository.ServiceRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ServiceProvidersRepository serviceProvidersRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    public ServiceProviderDTO createNewServiceProvider(ServiceProviderDTO serviceProviderDTOReq){
        ServiceProviderModel serviceProviderModel = modelMapper.map(serviceProviderDTOReq, ServiceProviderModel.class);
        ServiceProviderModel serviceProviderDbResponse = serviceProvidersRepository.save(serviceProviderModel);
        return  modelMapper.map(serviceProviderDbResponse,ServiceProviderDTO.class);
    }
//    TODO UNUSED CODE.
    @Transactional
    public ServiceProviderDTO getServiceProviderByName(ServiceProviderDTO serviceProviderDTOReq){
        ServiceProviderModel serviceProviderModel = modelMapper.map(serviceProviderDTOReq, ServiceProviderModel.class);
        ServiceProviderModel serviceProviderDbResponse = serviceProvidersRepository.findByName(serviceProviderDTOReq.getName());
        return  modelMapper.map(serviceProviderDbResponse,ServiceProviderDTO.class);
    }


    public List<ServiceProviderDTO> getAllServiceProviders(){
        List<ServiceProviderModel> serviceProvidersList= serviceProvidersRepository.findAll();

        List<ServiceProviderDTO> serviceProviderDtoList = serviceProvidersList.stream()
                .map(serviceProvider -> modelMapper.map(serviceProvider, ServiceProviderDTO.class))
                .collect(Collectors.toList());
        return serviceProviderDtoList;
    }

    @Transactional
    public List<ServiceProviderDTO> updateServiceProvider(ServiceProviderDTO serviceProviderDTORequest){
        ServiceProviderModel serviceProvider = serviceProvidersRepository.findById(serviceProviderDTORequest.getServiceProviderId())
                .orElseThrow(() -> new ResourceNotFoundException("serviceProvider  with id " + serviceProviderDTORequest.getServiceProviderId() + " not found"));

        serviceProvider.setName(serviceProviderDTORequest.getName());
        serviceProvider.setLocation(serviceProviderDTORequest.getLocation());
        return getAllServiceProviders();
    }

    public List<ServiceProviderDTO> deleteServiceProvider(ServiceProviderDTO serviceProviderDTORequest){
        ServiceProviderModel serviceProvider = serviceProvidersRepository.findById(serviceProviderDTORequest.getServiceProviderId())
                .orElseThrow(()-> new ResourceNotFoundException("ServiceProvider with id " + serviceProviderDTORequest.getServiceProviderId() + " not found"));

        serviceProvidersRepository.delete(serviceProvider);
        return getAllServiceProviders();
    }


}
