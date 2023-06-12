package com.fiona.premiumCalculation.Dependents.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(name="dependentId")
    private UUID dependentId;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="age")
    private Integer age;
    @Column(name="hasChronicDisease")
    private Boolean hasChronicDisease;
//    @ManyToOne
//    @JoinColumn(name="policyHolderId")
//    @JsonBackReference
//    private PolicyHolderModel policyHolderId;
////    -TODO add chronic disease -done
//    -TODO add validations eg phone number

//    private enum relateToPolicyHolder;


}
