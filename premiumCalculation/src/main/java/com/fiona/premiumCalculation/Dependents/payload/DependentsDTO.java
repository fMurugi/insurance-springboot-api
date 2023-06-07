package com.fiona.premiumCalculation.Dependents.payload;

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
    @NotNull(message = "Age cannot be null")
    private Integer age;
    // -TODO finf out if you can create a dependent without policyHolder ,it should reject
    private UUID policyHolderId;

//    TODO WRITE exception handling ,or error messages for these and others
}
