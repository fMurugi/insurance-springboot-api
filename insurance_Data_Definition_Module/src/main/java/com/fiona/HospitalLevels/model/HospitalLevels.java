package com.fiona.HospitalLevels.model;
//        ! todo  KINDLY ADD THE FILE, TO A FOLDER STSTING EHAT IT IS SUPPOSED TO DO, i.e repository,model,service e.t.c -dont understand this
import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Entity
@Data
@Table(name="data_hospital_levels")
public class HospitalLevels {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="levelId")
    @NonNull
    private UUID levelId;
    @Column(name="levelName")
    private String name;
    @OneToMany(mappedBy = "hospitalLevel")
    private ServiceProviderModel serviceProvider;

}
