package com.hospital.appointments.controllers;

import com.hospital.appointments.exceptions.NoEntityException;
import com.hospital.appointments.models.Patient;
import com.hospital.appointments.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.*;


@RestController
@RequestMapping("/patient")
@Component
public class PatientsController {
    @Autowired
    PatientRepository patientRepository;

    @GetMapping()
    public List<Patient> index(){
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient show(@PathVariable("id") int id){
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if(optionalPatient.isPresent()){
            Patient patient = optionalPatient.get();
            return patient;
        } else{
            return null;
        }
    }

    @PostMapping("/create")
    public Patient create(@ModelAttribute Patient patient){
        try{
            patientRepository.save(patient);
        } catch (Exception e){
            throw e;
        }
        return patient;
    }


}
