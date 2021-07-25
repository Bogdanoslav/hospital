package com.hospital.appointments.controllers;

import com.hospital.appointments.dto.save.doctor.SaveFamilyDoctor;
import com.hospital.appointments.model.Doctor;
import com.hospital.appointments.model.FamilyDoctor;
import com.hospital.appointments.model.SpecialistDoctor;
import com.hospital.appointments.repo.DoctorRepository;
import com.hospital.appointments.repo.FamilyDoctorRepository;
import com.hospital.appointments.repo.SpecialistDoctorRepository;
import com.hospital.appointments.services.DoctorService;
import com.hospital.appointments.services.FamilyDoctorService;
import com.hospital.appointments.services.SpecialistDoctorService;
import com.hospital.appointments.dto.filter.DoctorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    SpecialistDoctorService specialistDoctorService;
    @Autowired
    FamilyDoctorService familyDoctorService;

    @GetMapping("/all")
    public List<Doctor> findAllDoctors(@ModelAttribute DoctorFilter doctorFilter) {
        return doctorService.findAll(doctorFilter);
    }
    @GetMapping("/{id}")
    public Doctor findAllDoctors(Integer id) {
        return doctorService.findById(id);
    }

    @GetMapping("/specialist/all")
    public List<SpecialistDoctor> findAllSpecialistsDoctors(@ModelAttribute DoctorFilter doctorFilter) {
        return specialistDoctorService.findAll(doctorFilter);
    }
    @GetMapping("/specialist/{id}")
    public SpecialistDoctor findSpecialistDoctorById(@PathVariable Integer id) {
        return specialistDoctorService.findById(id);
    }
    @PostMapping("/specialist/create")
    public SpecialistDoctor saveSpecialistDoctor(@ModelAttribute SpecialistDoctor specialistDoctor){
        return specialistDoctorService.save(specialistDoctor);
    }

    @GetMapping("/family/all")
    public List<FamilyDoctor> findAllFamilyDoctors(@ModelAttribute DoctorFilter doctorFilter) {
        return  familyDoctorService.findAll(doctorFilter);
    }
    @GetMapping("/family/{id}")
    public FamilyDoctor findFamilyDoctorById(@PathVariable Integer id) {
        return  familyDoctorService.findById(id);
    }

    @PostMapping("/family/create")
    public FamilyDoctor saveFamilyDoctor(@ModelAttribute SaveFamilyDoctor familyDoctor){
        return familyDoctorService.save(familyDoctor);
    }
}
