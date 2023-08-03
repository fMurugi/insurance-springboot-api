package com.fiona.premiumCalculation.Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PremiumLimit {
    String premiumLimitId;
    int minimumAge;
    int maximumAge;
    int premium;
}
