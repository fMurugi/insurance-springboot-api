package com.fiona.ServiceProviders.Model;

import com.fiona.HospitalLevels.model.HospitalLevels;
import com.fiona.Limits.model.PremiumLimit;
import com.fiona.Services.Model.ServicesModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class ServiceProviderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID serviceProviderId;
    private String name;
    private String location;
    private String level;

    @ManyToMany(cascade = CascadeType.ALL)
            @JoinTable(
                    name = "serviceProviderService",
                    joinColumns = @JoinColumn(name = "serviceProviderId"),
                    inverseJoinColumns = @JoinColumn(name = "serviceId")
            )
    private Set<ServicesModel> services;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "levelId")
    private HospitalLevels hospitalLevel;

    @ManyToMany
    @JoinTable(
            name="serviceProviderLimits",
            joinColumns = @JoinColumn(name = "serviceProviderId"),
            inverseJoinColumns = @JoinColumn(name = "premiumLimitId")

    )
    private  Set<PremiumLimit> premiumLimit;


}
