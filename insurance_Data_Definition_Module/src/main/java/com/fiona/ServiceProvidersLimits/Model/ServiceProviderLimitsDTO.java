package com.fiona.ServiceProvidersLimits.Model;

import com.fiona.Limits.model.PremiumLimit;
import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.*;

import java.util.UUID;

public class ServiceProviderLimitsDTO {
    private UUID serviceProvidersLimitId;
    private UUID serviceProviderId;
    private UUID premiumLimitId;
    private Integer premium;
}
