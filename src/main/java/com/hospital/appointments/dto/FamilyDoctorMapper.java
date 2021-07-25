package com.hospital.appointments.dto;

import com.hospital.appointments.dto.save.doctor.SaveFamilyDoctor;
import com.hospital.appointments.model.FamilyDoctor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FamilyDoctorMapper {
    @Autowired
    private ModelMapper mapper;

    TypeMap<SaveFamilyDoctor, FamilyDoctor> typeMap;

//    public FamilyDoctor dtoToEntity(SaveFamilyDoctor saveFamilyDoctor){
//        return mapper.typeMap(SaveFamilyDoctor.class, FamilyDoctor.class)
//                .addMapping(SaveFamilyDoctor::getFirstName, FamilyDoctor::setFirstName)
//                .addMapping(SaveFamilyDoctor::getLastName, FamilyDoctor::setLastName)
//                .addMapping(SaveFamilyDoctor::getDistrict, FamilyDoctor::setDistrict).map(saveFamilyDoctor);
//    }
    public FamilyDoctor dtoToEntity(SaveFamilyDoctor saveFamilyDoctor){
        mapper.createTypeMap(SaveFamilyDoctor.class, FamilyDoctor.class).addMappings(mapper -> mapper.map(SaveFamilyDoctor::getLastName, FamilyDoctor::setLastName));
        return mapper.map(saveFamilyDoctor, FamilyDoctor.class);
    }
//    public FamilyDoctor dtoToEntity(SaveFamilyDoctor saveFamilyDoctor){
//        return mapper.typeMap(SaveFamilyDoctor.class, FamilyDoctor.class)
//                .addMappings(mapper -> {
//                    mapper.map(src -> src.getFirstName(),
//                            FamilyDoctor::setFirstName);
//                    mapper.map(src -> src.getLastName(),
//                            FamilyDoctor::setLastName);
//                    mapper.map(src -> src.getDistrict(),
//                            FamilyDoctor::setDistrict);
//                }).map(saveFamilyDoctor);
//    }
}
