package org.hospital.repo;

import org.hospital.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
