package com.fiona.ServiceProviders.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fiona.HospitalLevels.model.HospitalLevels;
import com.fiona.Limits.model.PremiumLimit;
import com.fiona.Services.Model.ServicesModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="data_service_provider")
public class ServiceProviderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="serviceProviderId")
    private UUID serviceProviderId;
    @Column(name="serviceProviderName")
    private String name;
    @Column(name="serviceProviderLocation")
    private String location;
   @OneToMany(mappedBy="serviceProviderId",cascade = CascadeType.ALL,orphanRemoval=true)
   @JsonManagedReference
    private List<ServicesModel> services;
    @ManyToOne
    @JoinColumn(name = "levelId")
    private HospitalLevels levelId;
    @OneToMany(mappedBy = "serviceProviderId",cascade =CascadeType.ALL,orphanRemoval = true )
    @Column(name="premiumLimitId")
    @JsonManagedReference
    private  List<PremiumLimit> premiumLimit ;


}
