package com.hospital.appointments.mappers;

import com.hospital.appointments.dto.save.SavePatient;
import com.hospital.appointments.model.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientsMapper {
  private ModelMapper mapper;

  @Autowired
  public PatientsMapper(ModelMapper mapper) {
    this.mapper = mapper;
  }

  public Patient dtoToEntity(SavePatient savePatient) {
    return mapper.map(savePatient, Patient.class);
  }
}
