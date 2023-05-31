package com.fiona.Services.payload;

import com.fiona.ServiceProviders.Model.ServiceProviderModel;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicesDTO {
    private UUID serviceId;
    @NotBlank(message="name cannot be blank")
    private String name;
    private Set<ServiceProviderModel> serviceProviders=new HashSet<>();


}
