package com.hospital.appointments.mappers;

import com.hospital.appointments.dto.save.SaveFamilyDoctor;
import com.hospital.appointments.model.FamilyDoctor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FamilyDoctorMapper {
  private ModelMapper mapper;

  @Autowired
  public FamilyDoctorMapper(ModelMapper mapper) {
    this.mapper = mapper;
  }

  public FamilyDoctor dtoToEntity(SaveFamilyDoctor saveFamilyDoctor) {
    return mapper.map(saveFamilyDoctor, FamilyDoctor.class);
  }
}
