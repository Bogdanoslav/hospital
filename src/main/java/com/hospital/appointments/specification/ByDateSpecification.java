package com.hospital.appointments.specification;

import com.hospital.appointments.model.Appointment_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ByDateSpecification<T> implements Specification<T> {
    Timestamp date;

    public ByDateSpecification(Timestamp date) {
        this.date = date;
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
        if (date == null) return cb.conjunction();

        Expression<Integer> dayExp = cb.function("day", Integer.class, root.get(Appointment_.START_TIME));
        Expression<Integer> monthExp = cb.function("month", Integer.class, root.get(Appointment_.START_TIME));
        Expression<Integer> yearExp = cb.function("year", Integer.class, root.get(Appointment_.START_TIME));

        LocalDateTime localDateTime = date.toLocalDateTime();
        Integer day = localDateTime.getDayOfMonth();
        Integer month = localDateTime.getMonth().getValue();
        Integer year = localDateTime.getYear();

        return cb.and(cb.equal(dayExp, day), cb.equal(monthExp, month), cb.equal(yearExp, year));
    }
}
