package com.hospital.appointments.services;

import com.hospital.appointments.dto.filter.PatientFilter;
import com.hospital.appointments.model.Patient;
import com.hospital.appointments.repo.PatientRepository;
import com.hospital.appointments.specification.patientSpecs.PatientSpecBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Transactional
    public static Specification<Patient> buildSpec(PatientFilter patientFilter) {
        return PatientSpecBuilder.buildSpecification(patientFilter);
    }
    @Transactional
    public List<Patient> findAll(PatientFilter patientFilter) {
        Specification<Patient> specification = buildSpec(patientFilter);
        return patientRepository.findAll(specification);
    }
    @Transactional
    public Patient findById(Integer id) {
        Optional<Patient> optPatient = patientRepository.findById(id);
        return optPatient.orElse(new Patient());
    }

    public Patient save(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }
}
