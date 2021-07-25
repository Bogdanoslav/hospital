package com.hospital.appointments.repo;

import com.hospital.appointments.model.Patient;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Transactional
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>, JpaSpecificationExecutor<Patient> {
}
