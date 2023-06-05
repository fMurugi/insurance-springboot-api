package com.fiona.ServiceProviders.Model;

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
   @OneToMany(mappedBy="serviceId",cascade = CascadeType.ALL,orphanRemoval=true)
    private List<ServicesModel> services;
    @ManyToOne
    @JoinColumn(name = "levelId")
    private HospitalLevels levelId;
    @OneToMany(mappedBy = "premiumLimitId",cascade =CascadeType.ALL,orphanRemoval = true )
    @Column(name="premiumLimitId")
    private  List<PremiumLimit> premiumLimit ;


}
