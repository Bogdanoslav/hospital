package com.hospital.appointments.specification;

import com.hospital.appointments.model.Appointment_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

public class ByDateSpecification<T> implements Specification<T> {
    Date date;

    public ByDateSpecification(Date date) {
        this.date = date;
    }

    @Override
    public Predicate toPredicate(
            Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (date == null) return criteriaBuilder.conjunction();
        return criteriaBuilder.equal(root.<Date>get(Appointment_.DATE), date);
    }
}
