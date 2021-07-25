package com.hospital.appointments.repo;

import com.hospital.appointments.model.FamilyDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FamilyDoctorRepository extends JpaRepository<FamilyDoctor, Integer>, JpaSpecificationExecutor<FamilyDoctor> {

}
