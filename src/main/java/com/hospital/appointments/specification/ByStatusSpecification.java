package com.hospital.appointments.specification;

import com.hospital.appointments.model.Appointment;
import com.hospital.appointments.model.Appointment_;
import liquibase.pro.packaged.T;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ByStatusSpecification<T> implements Specification<T> {
    String status;

    public ByStatusSpecification(String status) {
        this.status = status;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (status == null || status.isEmpty())
            return criteriaBuilder.conjunction();
        return criteriaBuilder.equal(root.get(Appointment_.STATUS), status);
    }
}
