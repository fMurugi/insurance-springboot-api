package com.fiona.Limits.model;

import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PremiumLimitDTO {
    private UUID premiumLimitId;
    @NotBlank(message = "minimum Age cannot be blank")
    private Integer minAge;
    @NotBlank(message = "maximum Age cannot be blank")
    private Integer maxAge;
    private  UUID serviceProviderId;
//    private Set<ServiceProviderModel> serviceProvider;

}
