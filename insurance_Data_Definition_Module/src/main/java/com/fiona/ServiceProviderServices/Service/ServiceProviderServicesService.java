package com.fiona.ServiceProviderServices.Service;

import com.fiona.ServiceProviders.Repository.ServiceProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProviderServicesService {
    @Autowired
    private ServiceProvidersRepository serviceProvidersRepository;
    //get All services given by a certain serviceProvider
//    public List<ServicesDTO> getAllServicesGivenByAServiceProvider(ServiceProviderDTO serviceProviderDTO){
//        //get the service provider
//        ServiceProviderModel serviceProviderModel = serviceProvidersRepository.findById(serviceProviderDTO.getServiceProviderId())
//                .orElseThrow();
//
//
//    }
}
