package com.fiona.Services.Model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicesDTO {
    private UUID serviceId;
    @NotBlank(message="name cannot be blank")
    private String name;

}
