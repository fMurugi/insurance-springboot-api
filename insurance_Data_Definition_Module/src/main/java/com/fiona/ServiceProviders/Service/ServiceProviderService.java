package com.fiona.ServiceProviders.Service;

import com.fiona.ServiceProviders.DTO.ServiceProviderDTO;
import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import com.fiona.ServiceProviders.Repository.ServiceProvidersRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ServiceProvidersRepository serviceProvidersRepository;

    public ServiceProviderDTO createNewServiceProvider(ServiceProviderDTO serviceProviderDTOReq){
        ServiceProviderModel serviceProviderModel = modelMapper.map(serviceProviderDTOReq, ServiceProviderModel.class);
        ServiceProviderModel serviceProviderDbResponse = serviceProvidersRepository.save(serviceProviderModel);
        return  modelMapper.map(serviceProviderDbResponse,ServiceProviderDTO.class);
    }
}
