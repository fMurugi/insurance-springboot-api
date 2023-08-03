package com.fiona.premiumCalculation.PolicyHolder.payload;



import com.fiona.premiumCalculation.Dependents.model.DependentsModel;

import com.fiona.premiumCalculation.Dependents.payload.DependentsDTO;
import com.fiona.premiumCalculation.Validation.ValidatePhoneNumber;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PolicyHolderDTO {
    private UUID policyHolderId;

    @NotBlank(message = "first name cannot be empty or null")
    private String firstName;
    @NotBlank(message = "last name cannot be empty or null")
    private String lastName;
    @Min(value= 18,message = "policy holder must be  18 years old and above")
    @Max(value = 60, message = "policy holder cannot be older than 60")
    private Integer age;
    private Boolean hasChronicDisease;

    @ValidatePhoneNumber
    private String phoneNumber;
    private List<DependentsDTO> dependents;



}
