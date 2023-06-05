package com.fiona.Limits.model;

import com.fiona.HospitalLevels.model.HospitalLevels;
import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name="data_premium_limit")
@AllArgsConstructor
@NoArgsConstructor
public class PremiumLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="premiumLimitId")
    private UUID premiumLimitId;
    @Column(name="minimumAge")
    @NotBlank
    private Integer minimumAge;
    @Column(name="maximumAge")
    @NotBlank
    private Integer maximumAge;
    @Column(name = "premium")
    private Integer premium;
    @ManyToOne
    @JoinColumn(name = "serviceProviderId")
    private ServiceProviderModel serviceProviderId;
}
