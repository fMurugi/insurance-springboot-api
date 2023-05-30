package com.fiona.Limits.model;

import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name="data_premium_limit")
public class PremiumLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NonNull
    @Column(name="premiumLimitId")
    private UUID premiumLimitId;
    @Column(name="minimumAge")
    @NotBlank
    private Integer minAge;
    @Column(name="maximumAge")
    @NotBlank
    private Integer maxAge;
    @ManyToMany(mappedBy = "premiumLimit")
    @Column(name="serviceProvider")
    private Set<ServiceProviderModel> serviceProvider;
}
