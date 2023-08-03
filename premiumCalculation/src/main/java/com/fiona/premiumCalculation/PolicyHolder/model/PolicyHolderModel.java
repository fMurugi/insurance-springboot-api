package com.fiona.premiumCalculation.PolicyHolder.model;


import com.fiona.premiumCalculation.Dependents.model.DependentsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonManagedReference;


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





    public PolicyHolderModel(String firstName, String lastName, Integer age, String phoneNumber, Boolean hasChronicDisease, List<DependentsModel> dependents) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.hasChronicDisease = hasChronicDisease;
        this.dependents = dependents;
    }
}
