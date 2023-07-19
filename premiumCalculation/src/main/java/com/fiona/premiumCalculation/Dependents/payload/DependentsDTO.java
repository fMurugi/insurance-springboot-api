package com.fiona.premiumCalculation.Dependents.payload;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DependentsDTO {
    private UUID dependentId;

    @NotBlank(message = "first name CANNOT BE EMPTY")
    private String firstName;
    @NotBlank(message = "last name CANNOT BE EMPTY")
    private String lastName;
    @Min(value = 0,message = "Age must be a positive number")
    @Max(value = 26,message = "dependant cannot be above 26 years old")
    private Integer age;
    private Boolean hasChronicDisease;
    // -TODO finf out if you can create a dependent without policyHolder ,it should reject
    private UUID policyHolderId;

//    TODO WRITE exception handling ,or error messages for these and others

}
