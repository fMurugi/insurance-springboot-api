package com.fiona.premiumCalculation.Dependents.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fiona.premiumCalculation.PolicyHolder.model.PolicyHolderModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name="premium_calculation_dependants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DependentsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID dependentId;
    private String firstName;
    private String lastName;
    private Integer Age;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name="policyHolderId")
    @JsonBackReference
    private PolicyHolderModel policyHolderId;
//    -TODO add chronic disease
//    -TODO add validations eg phone number


//    private enum relateToPolicyHolder;


}
