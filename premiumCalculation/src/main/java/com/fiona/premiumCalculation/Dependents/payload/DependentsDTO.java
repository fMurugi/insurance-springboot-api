package com.fiona.premiumCalculation.Dependents.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DependentsDTO {
    private UUID dependentId;
    private String firstName;
    private String lastName;
    private Integer Age;
    private UUID policyHolderId;
}
