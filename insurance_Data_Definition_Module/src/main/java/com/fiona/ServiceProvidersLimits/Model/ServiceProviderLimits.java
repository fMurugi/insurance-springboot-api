package com.fiona.ServiceProvidersLimits.Model;

import com.fiona.Limits.model.PremiumLimit;
import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "serviceProviderLimits")
public class ServiceProviderLimits {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID serviceProvidersLimitId;

    @ManyToOne
    @JoinColumn(name="serviceProviderId")
    private ServiceProviderModel serviceProviderModel;

    @ManyToOne
    @JoinColumn(name="premiumLimitId")
    private PremiumLimit premiumLimit;

    private Integer premium;

}
