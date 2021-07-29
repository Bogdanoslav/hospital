package com.hospital.appointments.dto;

import com.hospital.appointments.dto.save.patient.SavePatient;
import com.hospital.appointments.model.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientsMapper {
  @Autowired private ModelMapper mapper;
  //    public FamilyDoctor dtoToEntity(SaveFamilyDoctor saveFamilyDoctor){
  //        return mapper.typeMap(SaveFamilyDoctor.class, FamilyDoctor.class)
  //                .addMapping(SaveFamilyDoctor::getFirstName, FamilyDoctor::setFirstName)
  //                .addMapping(SaveFamilyDoctor::getLastName, FamilyDoctor::setLastName)
  //                .addMapping(SaveFamilyDoctor::getDistrict,
  // FamilyDoctor::setDistrict).map(saveFamilyDoctor);
  //    }
  public Patient dtoToEntity(SavePatient savePatient) {
    return mapper.map(savePatient, Patient.class);
  }
}
