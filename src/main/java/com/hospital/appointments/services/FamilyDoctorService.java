package com.hospital.appointments.services;

import com.hospital.appointments.mappers.FamilyDoctorMapper;
import com.hospital.appointments.dto.filter.DoctorFilter;
import com.hospital.appointments.dto.save.SaveFamilyDoctor;
import com.hospital.appointments.model.FamilyDoctor;
import com.hospital.appointments.repo.FamilyDoctorRepository;
import com.hospital.appointments.specification.doctorSpecs.FamilyDoctorSpecBuilder;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FamilyDoctorService {
  Logger logger = LoggerFactory.getLogger(FamilyDoctorService.class);

  FamilyDoctorRepository familyDoctorRepository;

  FamilyDoctorMapper familyDoctorMapper;

  @Autowired
  public FamilyDoctorService(FamilyDoctorRepository familyDoctorRepository, FamilyDoctorMapper familyDoctorMapper) {
    this.familyDoctorRepository = familyDoctorRepository;
    this.familyDoctorMapper = familyDoctorMapper;
  }

  public List<FamilyDoctor> findAll(DoctorFilter doctorFilter) {
    Specification<FamilyDoctor> specification = FamilyDoctorSpecBuilder.buildSpec(doctorFilter);
    return familyDoctorRepository.findAll(specification);
  }

  public FamilyDoctor findById(Integer id) {
    Optional<FamilyDoctor> doctor = familyDoctorRepository.findById(id);
    return doctor.orElse(null);
  }

  public FamilyDoctor save(SaveFamilyDoctor saveFamilyDoctor) {
    FamilyDoctor familyDoctor = familyDoctorMapper.dtoToEntity(saveFamilyDoctor);
    familyDoctorRepository.save(familyDoctor);
    logger.info("Family doctor was successfully saved.");
    return familyDoctor;
  }
}
