package com.hospital.appointments.services;

import com.hospital.appointments.mappers.SpecialistDoctorMapper;
import com.hospital.appointments.dto.filter.DoctorFilter;
import com.hospital.appointments.dto.save.SaveSpecialistDoctor;
import com.hospital.appointments.model.SpecialistDoctor;
import com.hospital.appointments.repo.SpecialistDoctorRepository;
import com.hospital.appointments.specification.doctorSpecs.SpecialistDoctorSpecBuilder;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class SpecialistDoctorService {
  Logger logger = LoggerFactory.getLogger(SpecialistDoctorService.class);

  SpecialistDoctorRepository specialistDoctorRepository;

  SpecialistDoctorMapper specialistDoctorMapper;

  @Autowired
  public SpecialistDoctorService(SpecialistDoctorRepository specialistDoctorRepository, SpecialistDoctorMapper specialistDoctorMapper) {
    this.specialistDoctorRepository = specialistDoctorRepository;
    this.specialistDoctorMapper = specialistDoctorMapper;
  }

  public List<SpecialistDoctor> findAll(DoctorFilter doctorFilter) {
    Specification<SpecialistDoctor> specification =
        SpecialistDoctorSpecBuilder.buildSpec(doctorFilter);
    return specialistDoctorRepository.findAll(specification);
  }

  public SpecialistDoctor findById(Integer id) {
    Optional<SpecialistDoctor> doctor = specialistDoctorRepository.findById(id);
    return doctor.orElse(null);
  }

  public SpecialistDoctor save(SaveSpecialistDoctor saveSpecialistDoctor) {
    SpecialistDoctor specialistDoctor = specialistDoctorMapper.dtoToEntity(saveSpecialistDoctor);
    specialistDoctorRepository.save(specialistDoctor);
    logger.info("Specialist doctor was successfully saved.");
    return specialistDoctor;
  }
}
