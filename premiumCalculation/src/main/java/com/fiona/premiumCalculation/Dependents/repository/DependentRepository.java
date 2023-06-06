package com.fiona.premiumCalculation.Dependents.repository;

import com.fiona.premiumCalculation.Dependents.model.DependentsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DependentRepository extends JpaRepository<DependentsModel, UUID> {
}
