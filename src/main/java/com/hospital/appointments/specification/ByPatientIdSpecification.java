package com.hospital.appointments.specification;

import com.hospital.appointments.model.Patient_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ByPatientIdSpecification<T> implements Specification<T> {
    Integer id;

    public ByPatientIdSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public Predicate toPredicate(
            Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (id == null) return criteriaBuilder.conjunction();
        return criteriaBuilder.equal(root.get("patient").get(Patient_.ID), id);
    }
}
