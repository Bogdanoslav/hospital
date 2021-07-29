package com.hospital.appointments.services;

import com.hospital.appointments.dto.SpecialistDoctorMapper;
import com.hospital.appointments.dto.filter.DoctorFilter;
import com.hospital.appointments.dto.save.doctor.SaveSpecialistDoctor;
import com.hospital.appointments.model.SpecialistDoctor;
import com.hospital.appointments.repo.SpecialistDoctorRepository;
import com.hospital.appointments.specification.doctorSpecs.SpecialistDoctorSpecBuilder;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class SpecialistDoctorService {
  @Autowired SpecialistDoctorRepository specialistDoctorRepository;

  @Autowired SpecialistDoctorMapper specialistDoctorMapper;

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
    return specialistDoctor;
  }
}
