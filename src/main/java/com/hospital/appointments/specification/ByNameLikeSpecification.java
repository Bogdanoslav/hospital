package com.hospital.appointments.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class ByNameLikeSpecification<T> implements Specification<T> {
    String name;

    public ByNameLikeSpecification(String name) {
        this.name = name;
    }

    @Override
    public Predicate toPredicate(
            Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (name == null || name.isEmpty()) return criteriaBuilder.conjunction();
        return criteriaBuilder.like(root.get("firstName"), "%" + name + "%");
    }
}
