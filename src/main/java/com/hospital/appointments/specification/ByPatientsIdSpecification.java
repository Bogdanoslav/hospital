package com.hospital.appointments.specification;

import com.hospital.appointments.model.FamilyDoctor_;
import com.hospital.appointments.model.Patient_;
import liquibase.pro.packaged.T;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ByPatientsIdSpecification<T>  implements Specification<T> {
    Integer id;

    public ByPatientsIdSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (id == null)
            return criteriaBuilder.conjunction();
//        return criteriaBuilder.isMember(id,root.get(FamilyDoctor_.PATIENTS));
        return criteriaBuilder.equal(root.join(FamilyDoctor_.PATIENTS).get(Patient_.ID), id);
    }
}
