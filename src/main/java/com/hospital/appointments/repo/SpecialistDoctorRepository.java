package com.hospital.appointments.repo;

import com.hospital.appointments.model.SpecialistDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpecialistDoctorRepository
    extends JpaRepository<SpecialistDoctor, Integer>, JpaSpecificationExecutor<SpecialistDoctor> {}
