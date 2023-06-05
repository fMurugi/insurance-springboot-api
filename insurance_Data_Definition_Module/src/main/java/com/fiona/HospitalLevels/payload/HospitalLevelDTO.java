package com.fiona.HospitalLevels.payload;

import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;
@Data
@AllArgsConstructor
public class HospitalLevelDTO {
    private UUID levelId;
    private String name;
//    private ServiceProviderModel serviceProvider;
}
