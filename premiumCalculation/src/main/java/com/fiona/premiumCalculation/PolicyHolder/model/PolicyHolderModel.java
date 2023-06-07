package com.fiona.premiumCalculation.PolicyHolder.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fiona.premiumCalculation.Dependents.model.DependentsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer phoneNumber;
    @OneToMany(mappedBy = "policyHolderId",cascade =CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<DependentsModel> dependents;

}
