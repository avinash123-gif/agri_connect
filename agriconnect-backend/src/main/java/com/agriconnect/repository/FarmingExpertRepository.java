package com.agriconnect.repository;

import com.agriconnect.model.FarmingExpert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmingExpertRepository extends JpaRepository<FarmingExpert, Long> {
}
