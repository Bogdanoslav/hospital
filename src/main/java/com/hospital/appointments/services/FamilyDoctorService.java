package com.hospital.appointments.services;

import com.hospital.appointments.dto.FamilyDoctorMapper;
import com.hospital.appointments.dto.filter.DoctorFilter;
import com.hospital.appointments.dto.save.doctor.SaveFamilyDoctor;
import com.hospital.appointments.model.FamilyDoctor;
import com.hospital.appointments.repo.FamilyDoctorRepository;
import com.hospital.appointments.specification.doctorSpecs.FamilyDoctorSpecBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyDoctorService {
    @Autowired
    FamilyDoctorRepository familyDoctorRepository;

    @Autowired
    FamilyDoctorMapper familyDoctorMapper;

    public List<FamilyDoctor> findAll(DoctorFilter doctorFilter) {
        Specification<FamilyDoctor> specification = FamilyDoctorSpecBuilder.buildSpec(doctorFilter);
        System.out.println("Count=" + familyDoctorRepository.count());
        return familyDoctorRepository.findAll(specification);
    }

    public FamilyDoctor findById(Integer id) {
        Optional<FamilyDoctor> doctor = familyDoctorRepository.findById(id);
        return doctor.orElse(null);
    }

    public FamilyDoctor save(SaveFamilyDoctor saveFamilyDoctor) {
        FamilyDoctor familyDoctor = familyDoctorMapper.dtoToEntity(saveFamilyDoctor);
        familyDoctorRepository.save(familyDoctor);
        return null;
    }
}
