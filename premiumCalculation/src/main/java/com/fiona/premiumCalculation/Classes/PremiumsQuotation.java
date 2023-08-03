package com.fiona.premiumCalculation.Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PremiumsQuotation {
    private String serviceProviderName;
    private int policyHolderPremiumLimit;
    private List<DependentPremiumLimit> dependents;
}
