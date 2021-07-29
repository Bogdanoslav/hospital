package com.hospital.appointments.services;

import com.hospital.appointments.dto.filter.DoctorFilter;
import com.hospital.appointments.model.Doctor;
import com.hospital.appointments.repo.DoctorRepository;
import com.hospital.appointments.specification.doctorSpecs.DoctorSpecBuilder;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
  @Autowired DoctorRepository doctorRepository;

  public List<Doctor> findAll(DoctorFilter doctorFilter) {
    Specification<Doctor> specification = DoctorSpecBuilder.buildSpec(doctorFilter);
    return doctorRepository.findAll(specification);
  }

  public Doctor findById(Integer id) {
    Optional<Doctor> doctor = doctorRepository.findById(id);
    return doctor.orElse(null);
  }

  public Doctor save(Doctor doctor) {
    doctorRepository.save(doctor);
    return doctor;
  }
}
