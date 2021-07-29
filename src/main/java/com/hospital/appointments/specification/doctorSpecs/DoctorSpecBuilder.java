package com.hospital.appointments.specification.doctorSpecs;

import com.hospital.appointments.dto.filter.DoctorFilter;
import com.hospital.appointments.model.Doctor;
import com.hospital.appointments.specification.ByNameLikeSpecification;
import com.hospital.appointments.specification.ByWorkingDaySpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class DoctorSpecBuilder {
    private DoctorSpecBuilder() {
    }

    public static Specification<Doctor> withWorkingDays(String day) {
        return new ByWorkingDaySpecification<>(day);
    }

    public static Specification<Doctor> withNameLike(String name) {
        return new ByNameLikeSpecification<>(name);
    }

    public static Specification<Doctor> buildSpec(DoctorFilter doctorFilter) {

        return withWorkingDays(doctorFilter.getDay()).and(withNameLike(doctorFilter.getFirstName()));
    }
}
