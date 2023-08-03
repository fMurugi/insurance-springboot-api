package com.fiona.premiumCalculation.Classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderServicesPremiums {
    private String serviceProviderId;
    private String name;
    private String location;
    private List <Service> services;
    private  List <PremiumLimit> premiumLimit ;
    private String levelId;
}
