package com.fiona.HospitalLevels.model;
//        ! todo  KINDLY ADD THE FILE, TO A FOLDER STSTING EHAT IT IS SUPPOSED TO DO, i.e repository,model,service e.t.c -dont understand this

import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@Entity
@Data
@Table(name="data_hospital_levels")
@AllArgsConstructor
@NoArgsConstructor
public class HospitalLevels {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="levelId")
    private UUID levelId;
    @Column(name="levelName")
    private String name;
    @OneToMany(mappedBy = "levelId",cascade = CascadeType.ALL,orphanRemoval=true)
    private List<ServiceProviderModel> serviceProvider;

}
