package com.securepayment.repository;

import com.securepayment.entity.ThreeDSecureDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreeDSecureDetailsRepository extends JpaRepository<ThreeDSecureDetails, Long> {

}
