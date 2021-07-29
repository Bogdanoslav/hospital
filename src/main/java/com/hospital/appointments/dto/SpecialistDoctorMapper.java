package com.hospital.appointments.dto;

import com.hospital.appointments.dto.save.doctor.SaveSpecialistDoctor;
import com.hospital.appointments.model.SpecialistDoctor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpecialistDoctorMapper {
  @Autowired private ModelMapper mapper;
  //    public FamilyDoctor dtoToEntity(SaveFamilyDoctor saveFamilyDoctor){
  //        return mapper.typeMap(SaveFamilyDoctor.class, FamilyDoctor.class)
  //                .addMapping(SaveFamilyDoctor::getFirstName, FamilyDoctor::setFirstName)
  //                .addMapping(SaveFamilyDoctor::getLastName, FamilyDoctor::setLastName)
  //                .addMapping(SaveFamilyDoctor::getDistrict,
  // FamilyDoctor::setDistrict).map(saveFamilyDoctor);
  //    }
  public SpecialistDoctor dtoToEntity(SaveSpecialistDoctor saveSpecialistDoctor) {
    return mapper.map(saveSpecialistDoctor, SpecialistDoctor.class);
  }
}
