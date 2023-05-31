package com.fiona.ServiceProviders.Model;

import com.fiona.HospitalLevels.model.HospitalLevels;
import com.fiona.Limits.model.PremiumLimit;
import com.fiona.Services.Model.ServicesModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="serviceProviderId")
    @NonNull
    private UUID serviceProviderId;
    @Column(name="serviceProviderName")
    private String name;
    @Column(name="serviceProviderLocation")
    private String location;

   @OneToMany(mappedBy="serviceId",cascade = CascadeType.ALL,orphanRemoval=true)
    private List<ServicesModel> services;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "levelId")
    @PrimaryKeyJoinColumn
    private HospitalLevels hospitalLevel;
    @ManyToMany
    @JoinTable(
            name="serviceProviderLimits",
            joinColumns = @JoinColumn(name = "serviceProviderId"),
            inverseJoinColumns = @JoinColumn(name = "premiumLimitId")
    )
    @Column(name="premiumLimit")
    private  Set<PremiumLimit> premiumLimit = new HashSet<>();


}
