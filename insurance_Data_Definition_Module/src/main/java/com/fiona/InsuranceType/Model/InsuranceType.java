package com.fiona.InsuranceType.Model;

import jakarta.persistence.*;
import lombok.*;
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
    private String name;
    @Column(name="insuranceTypeDescription")
    private String description;
}
