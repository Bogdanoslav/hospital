package com.hospital.appointments.controllers;

import com.hospital.appointments.dto.filter.PatientFilter;
import com.hospital.appointments.dto.save.patient.SavePatient;
import com.hospital.appointments.model.Patient;
import com.hospital.appointments.repo.PatientRepository;
import com.hospital.appointments.services.PatientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@Component
public class PatientsController {
  @Autowired PatientRepository patientRepository;

  @Autowired PatientService patientService;

  @GetMapping("/all")
  public List<Patient> findAllPatients(@ModelAttribute PatientFilter patientFilter) {
    return patientService.findAll(patientFilter);
  }

  @GetMapping("/{id}")
  public Patient findPatientById(@PathVariable Integer id) {
    return patientService.findById(id);
  }

  @PostMapping("/create")
  public Patient createPatient(@ModelAttribute SavePatient savePatient) {
    return patientService.save(savePatient);
  }
}
