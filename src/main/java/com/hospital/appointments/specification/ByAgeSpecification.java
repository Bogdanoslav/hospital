package com.hospital.appointments.specification;

import com.hospital.appointments.model.Patient_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ByAgeSpecification<T> implements Specification<T> {
    Integer age;

    public ByAgeSpecification(Integer age) {
        this.age = age;
    }

    @Override
    public Predicate toPredicate(
            Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (age == null) return criteriaBuilder.conjunction();
        return criteriaBuilder.equal(root.get(Patient_.AGE), age);
    }
}
