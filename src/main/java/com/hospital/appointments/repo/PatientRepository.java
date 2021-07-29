package com.hospital.appointments.repo;

import com.hospital.appointments.model.Patient;
import java.util.*;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface PatientRepository
    extends JpaRepository<Patient, Integer>, JpaSpecificationExecutor<Patient> {}
