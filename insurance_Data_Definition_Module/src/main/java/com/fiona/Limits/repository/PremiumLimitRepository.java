package com.fiona.Limits.repository;

import com.fiona.Limits.model.PremiumLimit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PremiumLimitRepository extends JpaRepository<PremiumLimit, UUID> {
}
