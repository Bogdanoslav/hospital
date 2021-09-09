package com.hospital.appointments.mappers;

import com.hospital.appointments.dto.save.SaveSpecialistDoctor;
import com.hospital.appointments.model.SpecialistDoctor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpecialistDoctorMapper {
  private ModelMapper mapper;

  @Autowired
  public SpecialistDoctorMapper(ModelMapper mapper) {
    this.mapper = mapper;
  }

  public SpecialistDoctor dtoToEntity(SaveSpecialistDoctor saveSpecialistDoctor) {
    return mapper.map(saveSpecialistDoctor, SpecialistDoctor.class);
  }
}
