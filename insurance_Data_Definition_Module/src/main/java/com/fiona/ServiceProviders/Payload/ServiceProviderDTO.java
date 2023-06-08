package com.fiona.ServiceProviders.Payload;

import com.fiona.HospitalLevels.model.HospitalLevels;
import com.fiona.Limits.model.PremiumLimit;
import com.fiona.Services.Model.ServicesModel;
import com.fiona.Services.payload.ServicesDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderDTO {
    private UUID serviceProviderId;
    private String name;
    private String location;
    private List<ServicesModel> services;
    private  List<PremiumLimit> premiumLimit ;
    private UUID levelId;


}
