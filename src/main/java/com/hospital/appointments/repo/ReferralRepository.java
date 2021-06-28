package com.hospital.appointments.repo;

import com.hospital.appointments.models.Referral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferralRepository extends JpaRepository<Referral, Integer> {
}
