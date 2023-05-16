package com.fiona.ServiceProviders.Model;

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

}
