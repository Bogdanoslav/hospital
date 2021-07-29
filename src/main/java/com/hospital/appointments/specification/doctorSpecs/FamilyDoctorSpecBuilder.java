package com.hospital.appointments.specification.doctorSpecs;

import com.hospital.appointments.dto.filter.DoctorFilter;
import com.hospital.appointments.model.FamilyDoctor;
import com.hospital.appointments.specification.ByNameLikeSpecification;
import com.hospital.appointments.specification.ByPatientsIdSpecification;
import com.hospital.appointments.specification.ByWorkingDaySpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class FamilyDoctorSpecBuilder {
    public FamilyDoctorSpecBuilder() {
    }

    public static Specification<FamilyDoctor> withWorkingDays(String day) {
        return new ByWorkingDaySpecification<>(day);
    }

    public static Specification<FamilyDoctor> withNameLike(String name) {
        return new ByNameLikeSpecification<>(name);
    }

    public static Specification<FamilyDoctor> withPatientsId(Integer id) {
        return new ByPatientsIdSpecification<>(id);
    }

    public static Specification<FamilyDoctor> buildSpec(DoctorFilter doctorFilter) {
        return withWorkingDays(doctorFilter.getDay())
                .and(withNameLike(doctorFilter.getFirstName()))
                .and(withPatientsId(doctorFilter.getPatientId()));
    }
}
