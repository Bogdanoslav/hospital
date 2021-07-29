package com.hospital.appointments.specification;

import com.hospital.appointments.model.SpecialistDoctor_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BySpecialtySpecification<T> implements Specification<T> {
    String specialty;

    public BySpecialtySpecification(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public Predicate toPredicate(
            Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (specialty == null || specialty.isEmpty()) return criteriaBuilder.conjunction();
        return criteriaBuilder.equal(root.get(SpecialistDoctor_.SPECIALTY), specialty);
    }
}
