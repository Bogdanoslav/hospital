package com.hospital.appointments.services;

import com.hospital.appointments.dto.filter.PatientFilter;
import com.hospital.appointments.dto.save.SavePatient;
import com.hospital.appointments.mappers.PatientsMapper;
import com.hospital.appointments.model.Patient;
import com.hospital.appointments.repo.PatientRepository;
import com.hospital.appointments.specification.patientSpecs.PatientSpecBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    Logger logger = LoggerFactory.getLogger(PatientService.class);

    PatientRepository patientRepository;

    PatientsMapper patientsMapper;

    @Autowired
    public PatientService(PatientRepository patientRepository, PatientsMapper patientsMapper) {
        this.patientRepository = patientRepository;
        this.patientsMapper = patientsMapper;
    }

    public List<Patient> findAll(PatientFilter patientFilter) {
        Specification<Patient> specification = PatientSpecBuilder.buildSpecification(patientFilter);
        return patientRepository.findAll(specification);
    }

    public Patient findById(Integer id) {
        Optional<Patient> optPatient = patientRepository.findById(id);
        return optPatient.orElse(new Patient());
    }

    public Patient save(SavePatient savePatient) {
        Patient patient = patientsMapper.dtoToEntity(savePatient);
        patientRepository.save(patient);
        logger.info("Patient was successfully saved.");
        return patient;
    }
}
