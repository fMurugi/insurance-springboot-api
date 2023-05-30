package com.fiona.HospitalLevels.model;
//        ! todo  KINDLY ADD THE FILE, TO A FOLDER STSTING EHAT IT IS SUPPOSED TO DO, i.e repository,model,service e.t.c
import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="data_hospital_levels")
public class HospitalLevels {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID levelId;
    private String name;
    @OneToOne(mappedBy = "hospitalLevel")
    private ServiceProviderModel serviceProvider;

}
