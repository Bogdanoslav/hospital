package com.hospital.appointments.controllers;

import com.hospital.appointments.models.Patient;
import com.hospital.appointments.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/patients")
@Component
public class PatientsController {
    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/all")
    public List<Patient> index() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient showById(@PathVariable("id") int id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            return patient;
        } else {
            return null;
        }
    }
    @GetMapping()
    public Patient showByFirstName(@RequestParam(value="firstName") String firstName) {
        Patient patient = patientRepository.findByFirstName(firstName);
        return patient;
    }

    @PostMapping("/create")
    public Patient create(@ModelAttribute Patient patient) {
        try {
            patientRepository.save(patient);
        } catch (Exception e) {
            throw e;
        }
        return patient;
    }


}
