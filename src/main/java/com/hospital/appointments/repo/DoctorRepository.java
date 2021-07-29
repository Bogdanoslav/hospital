package com.hospital.appointments.repo;

import com.hospital.appointments.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DoctorRepository
    extends JpaRepository<Doctor, Integer>, JpaSpecificationExecutor<Doctor> {}
