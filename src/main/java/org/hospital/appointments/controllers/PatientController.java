package org.hospital.appointments.controllers;

import org.hospital.models.Patient;
import org.hospital.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/create")
    @ResponseBody
    public String create() {
        Patient patient = null;
        try {
            patient = new Patient();
            patient.setAge(23);
            patient.setFirstName("Ivan");
            patient.setLastName("Ivan");
            patient.setDistrict(14);
            patientRepository.save(patient);
        } catch (Exception ex) {
            return "Error creating the patient: " + ex.toString();
        }
        return "Patient succesfully created!";
    }

}
