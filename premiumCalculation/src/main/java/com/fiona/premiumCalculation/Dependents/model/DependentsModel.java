package com.fiona.premiumCalculation.Dependents.model;

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
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="policyHolderId")
    private PolicyHolderModel policyHolderId;

//    private enum relateToPolicyHolder;


}
