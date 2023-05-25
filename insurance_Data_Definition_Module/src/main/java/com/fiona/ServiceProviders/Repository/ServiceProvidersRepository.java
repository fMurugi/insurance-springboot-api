package com.fiona.ServiceProviders.Repository;

import com.fiona.ServiceProviders.Model.ServiceProviderDTO;
import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ServiceProvidersRepository extends JpaRepository<ServiceProviderModel,UUID> {
    ServiceProviderModel findByName(String name);
}
