package com.hospital.appointments.repo;

import com.hospital.appointments.model.Doctor;
import com.hospital.appointments.model.Patient;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.print.Doc;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>, JpaSpecificationExecutor<Doctor> {
}
