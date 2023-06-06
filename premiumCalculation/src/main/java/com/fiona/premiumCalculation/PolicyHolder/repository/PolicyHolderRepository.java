package com.fiona.premiumCalculation.PolicyHolder.repository;

import com.fiona.premiumCalculation.PolicyHolder.model.PolicyHolderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PolicyHolderRepository extends JpaRepository<PolicyHolderModel, UUID> {
}
