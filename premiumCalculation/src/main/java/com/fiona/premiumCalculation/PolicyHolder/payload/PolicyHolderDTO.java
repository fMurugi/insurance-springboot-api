package com.fiona.premiumCalculation.PolicyHolder.payload;



import com.fiona.premiumCalculation.Dependents.model.DependentsModel;
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
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer phoneNumber;
    private List<DependentsModel> dependents;

}
