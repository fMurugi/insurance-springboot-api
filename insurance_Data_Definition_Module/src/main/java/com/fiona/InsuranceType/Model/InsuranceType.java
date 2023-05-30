package com.fiona.InsuranceType.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.util.UUID;

@Entity
@Data
@Setter
@Table(name = "data_insuranceType")

// TODO, EXPLICITLY ADD THE COLUMN NAMES. AND ANY OTHER REQUIRED FIELD SUCH AS NOT NULL, ETC.
public class InsuranceType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID insuranceTypeId;
    private String name;
    private String description;
}
