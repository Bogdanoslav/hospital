package com.hospital.appointments.specification;

import com.hospital.appointments.model.Appointment;
import com.hospital.appointments.model.Appointment_;
import com.hospital.appointments.model.Doctor_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ByDoctorIdSpecification<T> implements Specification<T> {
    Integer id;

    public ByDoctorIdSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (id == null)
            return criteriaBuilder.conjunction();
        return criteriaBuilder.equal(root.get(Appointment_.DOCTOR).get(Doctor_.ID), id);
    }
}
