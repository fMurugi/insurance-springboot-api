package com.fiona.premiumCalculation.Classes;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
public class ServiceProviderServicesPremiums {
    private UUID serviceProviderId;
    private String name;
    private String location;
    private List services;
    private  List premiumLimit ;
    private UUID levelId;
}
