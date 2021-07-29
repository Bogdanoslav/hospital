package com.hospital.appointments.repo;

import com.hospital.appointments.model.Referral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReferralRepository
    extends JpaRepository<Referral, Integer>, JpaSpecificationExecutor<Referral> {}
