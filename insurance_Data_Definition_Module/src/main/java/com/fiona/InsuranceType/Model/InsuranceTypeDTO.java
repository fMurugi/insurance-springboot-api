package com.fiona.InsuranceType.Model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceTypeDTO {
    private UUID insuranceTypeId;
    @NotBlank(message = "Name cannot be blank/null")
    private String name;
    @NotBlank(message = "description cannot be null/blank")
    private String description;


}
