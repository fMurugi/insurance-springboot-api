package com.fiona.ServiceProviders.Service;

import com.fiona.Exceptions.ResourceNotFoundException;
import com.fiona.HospitalLevels.payload.HospitalLevelDTO;
import com.fiona.ServiceProviders.Payload.ServiceProviderDTO;
import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import com.fiona.ServiceProviders.Repository.ServiceProvidersRepository;
import com.fiona.Services.Model.ServicesModel;
import com.fiona.Services.payload.ServicesDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
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

        return serviceProvidersList.stream()
                .map(serviceProvider -> {
                    ServiceProviderDTO serviceProviderDTO = modelMapper.map(serviceProvider, ServiceProviderDTO.class);
                    return serviceProviderDTO;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ServiceProviderDTO> updateServiceProvider(ServiceProviderDTO data){
        ServiceProviderModel serviceProvider =findServiceProviderById(data.getServiceProviderId());
        serviceProvider.setName(data.getName());
        serviceProvider.setLocation(data.getLocation());
        return getAllServiceProviders();
    }

    public List<ServiceProviderDTO> deleteServiceProvider(ServiceProviderDTO data){
        ServiceProviderModel serviceProvider = findServiceProviderById(data.getServiceProviderId());
        serviceProvidersRepository.delete(serviceProvider);
        return getAllServiceProviders();
    }

    public ServiceProviderDTO getServiceProviderByName(ServiceProviderDTO data) {
        return  modelMapper.map(serviceProvidersRepository.findByName(data.getName()),ServiceProviderDTO.class);
    }

//    public List<HospitalLevelDTO> getHospitalsByLevelId(HospitalLevelDTO servicesDTO) {
//        UUID serviceProviderId = servicesDTO.getServiceProviderId();
//        ServiceProviderModel serviceProvider = serviceProvidersRepository.findById(serviceProviderId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid serviceProviderId: " + serviceProviderId));
//
//        List<ServicesModel> services = serviceRepository.findServiceByServiceProviderId(serviceProvider);
//
//        return services.stream()
//                .map(service -> modelMapper.map(service, ServicesDTO.class))
//                .collect(Collectors.toList());
//    }
    public ServiceProviderModel findServiceProviderById(UUID id){
        return serviceProvidersRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Service Provider does not exist"));

    }
}
