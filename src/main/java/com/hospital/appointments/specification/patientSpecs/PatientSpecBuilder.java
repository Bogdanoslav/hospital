package com.hospital.appointments.specification.patientSpecs;

import com.hospital.appointments.dto.filter.PatientFilter;
import com.hospital.appointments.model.Patient;
import com.hospital.appointments.specification.ByAgeSpecification;
import com.hospital.appointments.specification.ByNameLikeSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PatientSpecBuilder {
    private PatientSpecBuilder() {

    }

    public static Specification<Patient> withName(String name) {
        return new ByNameLikeSpecification(name);
    }

    public static Specification<Patient> withAge(Integer age) {
        return new ByAgeSpecification(age);
    }

    public  static Specification<Patient> buildSpecification(PatientFilter patientFilter) {
        return withName(patientFilter.getFirstName())
                .and(withAge(patientFilter.getAge()));
    }
}
