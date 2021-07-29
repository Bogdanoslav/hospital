package com.hospital.appointments.specification;

import com.hospital.appointments.model.Doctor_;
import com.hospital.appointments.model.WorkingHours_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ByWorkingDaySpecification<T> implements Specification<T> {
    String day;

    public ByWorkingDaySpecification(String day) {
        this.day = day;
    }

    @Override
    public Predicate toPredicate(
            Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (day == null || day.isEmpty()) return criteriaBuilder.conjunction();
        return criteriaBuilder.equal(root.join(Doctor_.WORKING_HOURS).get(WorkingHours_.DAY), day);
    }
}
