package com.fiona.ServiceProvidersLimits.Repository;

import com.fiona.ServiceProvidersLimits.Model.ServiceProviderLimits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceProvidersLimitsRepository extends JpaRepository<ServiceProviderLimits, UUID> {
}
