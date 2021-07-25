package com.hospital.appointments.services;

import com.hospital.appointments.dto.filter.PatientFilter;
import com.hospital.appointments.model.FamilyDoctor;
import com.hospital.appointments.model.Patient;
import com.hospital.appointments.model.SpecialistDoctor;
import com.hospital.appointments.dto.filter.DoctorFilter;
import com.hospital.appointments.repo.FamilyDoctorRepository;
import com.hospital.appointments.repo.PatientRepository;
import com.hospital.appointments.repo.SpecialistDoctorRepository;
import com.hospital.appointments.specification.doctorSpecs.FamilyDoctorSpecBuilder;
import com.hospital.appointments.specification.doctorSpecs.SpecialistDoctorSpecBuilder;
import com.hospital.appointments.specification.patientSpecs.PatientSpecBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialistDoctorService {
    @Autowired
    SpecialistDoctorRepository specialistDoctorRepository;

    public List<SpecialistDoctor> findAll(DoctorFilter doctorFilter) {
        Specification<SpecialistDoctor> specification = SpecialistDoctorSpecBuilder.buildSpec(doctorFilter);
        return specialistDoctorRepository.findAll(specification);
    }

    public SpecialistDoctor findById(Integer id) {
        Optional<SpecialistDoctor> doctor = specialistDoctorRepository.findById(id);
        return doctor.orElse(null);
    }

    public SpecialistDoctor save(SpecialistDoctor specialistDoctor) {
        specialistDoctorRepository.save(specialistDoctor);
        return specialistDoctor;
    }
}
