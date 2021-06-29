package com.hospital.appointments.repo;

import com.hospital.appointments.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    public Patient findByFirstName(String firstName);
}
