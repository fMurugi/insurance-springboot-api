package com.fiona.InsuranceType.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceTypeDTO {
    @NotBlank(message = "Name cannot be blank/null")
    private String name;
    @NotBlank(message = "description cannot be null/blank")
    private String description;


}
