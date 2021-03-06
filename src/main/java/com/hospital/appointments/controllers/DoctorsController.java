package com.hospital.appointments.controllers;

import com.hospital.appointments.dto.filter.DoctorFilter;
import com.hospital.appointments.dto.save.SaveFamilyDoctor;
import com.hospital.appointments.dto.save.SaveSpecialistDoctor;
import com.hospital.appointments.model.Doctor;
import com.hospital.appointments.model.FamilyDoctor;
import com.hospital.appointments.model.SpecialistDoctor;
import com.hospital.appointments.services.DoctorService;
import com.hospital.appointments.services.FamilyDoctorService;
import com.hospital.appointments.services.SpecialistDoctorService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {
    private static Logger logger = LoggerFactory.getLogger(DoctorsController.class);

    DoctorService doctorService;
    SpecialistDoctorService specialistDoctorService;
    FamilyDoctorService familyDoctorService;

    @Autowired
    public DoctorsController(DoctorService doctorService,
                             SpecialistDoctorService specialistDoctorService,
                             FamilyDoctorService familyDoctorService) {
        this.doctorService = doctorService;
        this.specialistDoctorService = specialistDoctorService;
        this.familyDoctorService = familyDoctorService;
    }

    @GetMapping("/all")
    public List<Doctor> findAllDoctors(@ModelAttribute DoctorFilter doctorFilter) {
        return doctorService.findAll(doctorFilter);
    }

    @GetMapping("/{id}")
    public Doctor findAllDoctors(@PathVariable Integer id) {
        return doctorService.findById(id);
    }

    @GetMapping("/specialist/all")
    public List<SpecialistDoctor> findAllSpecialistsDoctors(
            @ModelAttribute DoctorFilter doctorFilter) {
        return specialistDoctorService.findAll(doctorFilter);
    }

    @GetMapping("/specialist/{id}")
    public SpecialistDoctor findSpecialistDoctorById(@PathVariable Integer id) {
        return specialistDoctorService.findById(id);
    }

    @PostMapping("/specialist/create")
    public SpecialistDoctor saveSpecialistDoctor(
            @ModelAttribute SaveSpecialistDoctor saveSpecialistDoctor) {
        return specialistDoctorService.save(saveSpecialistDoctor);
    }

    @GetMapping("/family/all")
    public List<FamilyDoctor> findAllFamilyDoctors(@ModelAttribute DoctorFilter doctorFilter) {
        return familyDoctorService.findAll(doctorFilter);
    }

    @GetMapping("/family/{id}")
    public FamilyDoctor findFamilyDoctorById(@PathVariable Integer id) {
        return familyDoctorService.findById(id);
    }

    @PostMapping("/family/create")
    public FamilyDoctor saveFamilyDoctor(@ModelAttribute SaveFamilyDoctor familyDoctor) {
        return familyDoctorService.save(familyDoctor);
    }
}
