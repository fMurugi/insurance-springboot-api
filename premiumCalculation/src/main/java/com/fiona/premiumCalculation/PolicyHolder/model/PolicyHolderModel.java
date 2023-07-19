package com.fiona.premiumCalculation.PolicyHolder.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fiona.premiumCalculation.Dependents.model.DependentsModel;
import com.fiona.premiumCalculation.Validation.ValidatePhoneNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="policyHolder")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyHolderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID policyHolderId;
    private String firstName;
    private String lastName;
    private Integer age;

    private String phoneNumber;
    private Boolean hasChronicDisease;
    @OneToMany(mappedBy = "policyHolderId",cascade =CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference

    private List<DependentsModel> dependents;

}
