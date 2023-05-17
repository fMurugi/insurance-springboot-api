package com.fiona.InsuranceType.Repository;

import com.fiona.InsuranceType.Model.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InsuranceTypeRepository extends JpaRepository<InsuranceType, UUID> {
}
