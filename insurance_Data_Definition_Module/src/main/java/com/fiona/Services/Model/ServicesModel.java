package com.fiona.Services.Model;

import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="data_services")
public class ServicesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="serviceId")
    private UUID serviceId;
    @Column(unique = true,name="serviceName")
    private String name;
    @ManyToOne
    @JoinColumn(name="serviceProviderId")
    private ServiceProviderModel serviceProviderModel;

}
