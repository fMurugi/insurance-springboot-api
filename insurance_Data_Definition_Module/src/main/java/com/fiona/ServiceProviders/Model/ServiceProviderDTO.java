package com.fiona.ServiceProviders.Model;

import com.fiona.HospitalLevels.model.HospitalLevels;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderDTO {
    private UUID serviceProviderId;
    @NotBlank(message="name cannot be BLANK")
    private String name;
    @NotBlank(message = "location cannot be BLANK")
    private String location;
    private HospitalLevels hospitalLevel;

}
