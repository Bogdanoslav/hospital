package com.hospital.appointments.specification.doctorSpecs;

import com.hospital.appointments.dto.filter.DoctorFilter;
import com.hospital.appointments.model.SpecialistDoctor;
import com.hospital.appointments.specification.ByNameLikeSpecification;
import com.hospital.appointments.specification.BySpecialtySpecification;
import com.hospital.appointments.specification.ByWorkingDaySpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class SpecialistDoctorSpecBuilder {
  public SpecialistDoctorSpecBuilder() {}

  public static Specification<SpecialistDoctor> withWorkingDays(String day) {
    return new ByWorkingDaySpecification<>(day);
  }

  public static Specification<SpecialistDoctor> withNameLike(String name) {
    return new ByNameLikeSpecification<>(name);
  }

  public static Specification<SpecialistDoctor> withSpecialty(String specialty) {
    return new BySpecialtySpecification<>(specialty);
  }

  public static Specification<SpecialistDoctor> buildSpec(DoctorFilter doctorFilter) {

    return withWorkingDays(doctorFilter.getDay())
        .and(withNameLike(doctorFilter.getFirstName()))
        .and(withSpecialty(doctorFilter.getSpecialty()));
  }
}
