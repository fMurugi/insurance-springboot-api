package com.fiona.Limits.Payload;

import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PremiumLimitDTO {
    private UUID premiumLimitId;
    private Integer minimumAge;
    private Integer maximumAge;
    private Integer premium;
    private UUID serviceProviderId;

}
