package com.fiona.InsuranceType.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Setter;

import java.util.UUID;

@Entity
@Data
@Setter
public class InsuranceType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID insuranceTypeId;
    private String name;
    private String description;
}
