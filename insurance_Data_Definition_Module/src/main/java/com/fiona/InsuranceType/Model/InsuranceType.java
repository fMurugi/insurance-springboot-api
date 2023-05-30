package com.fiona.InsuranceType.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Setter;

import java.util.UUID;

@Entity
@Data
@Setter
@Table(name = "data_insuranceType")

// TODO, EXPLICITLY ADD THE COLUMN NAMES. AND ANY OTHER REQUIRED FIELD SUCH AS NOT NULL, ETC. - done
public class InsuranceType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID insuranceTypeId;
    @Column(name = "insuranceTypeName")
    @NotBlank
    private String name;
    @Column(name="insuranceTypeDescription")
    @NotBlank
    private String description;
}
