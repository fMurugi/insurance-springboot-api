package com.fiona.Limits.model;

import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.*;
import lombok.*;
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
    private Integer minimumAge;
    @Column(name="maximumAge")
    private Integer maximumAge;
    @Column(name = "premium")
    private Integer premium;
    @ManyToOne
    @JoinColumn(name = "serviceProviderId")
    private ServiceProviderModel serviceProviderId;
}
