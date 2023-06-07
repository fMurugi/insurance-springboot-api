package com.fiona.HospitalLevels.repository;

import com.fiona.HospitalLevels.model.HospitalLevels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HospitalLevelsRepository extends JpaRepository<HospitalLevels, UUID>{
}
