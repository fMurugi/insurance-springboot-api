package com.fiona.Limits.model;

import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class PremiumLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID premiumLimitId;

    private Integer minAge;
    private Integer maxAge;

    @ManyToMany(mappedBy = "premiumLimit")
    private Set<ServiceProviderModel> serviceProvider;

}
