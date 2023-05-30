package com.fiona.ServiceProviders.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fiona.HospitalLevels.model.HospitalLevels;
import com.fiona.Limits.model.PremiumLimit;
import com.fiona.Services.Model.ServicesModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
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
    private UUID serviceProviderId;
    private String name;
    private String location;


    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
            @JoinTable(
                    name = "serviceProviderService",
                    joinColumns = @JoinColumn(name = "serviceProviderId"),
                    inverseJoinColumns = @JoinColumn(name = "serviceId")
            )
    private Set<ServicesModel> services = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "levelId")
    private HospitalLevels hospitalLevel;
    @ManyToMany
    @JoinTable(
            name="serviceProviderLimits",
            joinColumns = @JoinColumn(name = "serviceProviderId"),
            inverseJoinColumns = @JoinColumn(name = "premiumLimitId")
    )
    private  Set<PremiumLimit> premiumLimit = new HashSet<>();


}
