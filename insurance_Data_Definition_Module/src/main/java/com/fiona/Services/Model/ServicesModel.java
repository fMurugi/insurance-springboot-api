package com.fiona.Services.Model;

import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class ServicesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID serviceId;
    private String name;

    @ManyToMany(mappedBy="services")
    private Set<ServiceProviderModel> serviceProviders;

}
