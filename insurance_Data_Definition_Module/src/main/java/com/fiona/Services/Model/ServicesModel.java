package com.fiona.Services.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.CodePointLength;

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
    private UUID serviceId;
    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy="services",fetch = FetchType.LAZY,cascade = { CascadeType.ALL })

    private Set<ServiceProviderModel> serviceProviders=new HashSet<>();


}
