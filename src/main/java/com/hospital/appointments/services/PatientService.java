package com.hospital.appointments.services;

import com.hospital.appointments.dto.PatientsMapper;
import com.hospital.appointments.dto.filter.PatientFilter;
import com.hospital.appointments.dto.save.patient.SavePatient;
import com.hospital.appointments.model.Patient;
import com.hospital.appointments.repo.PatientRepository;
import com.hospital.appointments.specification.patientSpecs.PatientSpecBuilder;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
  @Autowired PatientRepository patientRepository;

  @Autowired PatientsMapper patientsMapper;

  public static Specification<Patient> buildSpec(PatientFilter patientFilter) {
    return PatientSpecBuilder.buildSpecification(patientFilter);
  }

  public List<Patient> findAll(PatientFilter patientFilter) {
    Specification<Patient> specification = buildSpec(patientFilter);
    return patientRepository.findAll(specification);
  }

  public Patient findById(Integer id) {
    Optional<Patient> optPatient = patientRepository.findById(id);
    return optPatient.orElse(new Patient());
  }

  public Patient save(SavePatient savePatient) {
    Patient patient = patientsMapper.dtoToEntity(savePatient);
    patientRepository.save(patient);
    return patient;
  }
}
