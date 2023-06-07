package com.fiona.Limits.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
