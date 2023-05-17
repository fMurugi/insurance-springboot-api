package com.fiona.HospitalLevels.model;

import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class HospitalLevels {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID levelId;
    private String name;

    @OneToOne(mappedBy = "hospitalLevel")
    private ServiceProviderModel serviceProvider;

}
