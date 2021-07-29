package com.hospital.appointments.specification.appointmentSpecs;

import com.hospital.appointments.dto.filter.AppointmentFilter;
import com.hospital.appointments.model.Appointment;
import com.hospital.appointments.specification.ByDateSpecification;
import com.hospital.appointments.specification.ByDoctorIdSpecification;
import com.hospital.appointments.specification.ByPatientIdSpecification;
import com.hospital.appointments.specification.ByStatusSpecification;
import java.util.Date;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AppointmentsSpecBuilder {

  public AppointmentsSpecBuilder() {}

  public static Specification<Appointment> withDate(Date date) {
    return new ByDateSpecification<>(date);
  }

  public static Specification<Appointment> withDoctorId(Integer id) {
    return new ByDoctorIdSpecification<>(id);
  }

  public static Specification<Appointment> withPatientId(Integer id) {
    return new ByPatientIdSpecification<>(id);
  }

  public static Specification<Appointment> withStatus(String status) {
    return new ByStatusSpecification<>(status);
  }

  public static Specification<Appointment> buildSpec(AppointmentFilter appointmentFilter) {
    return withDate(appointmentFilter.getDate())
        .and(withDoctorId(appointmentFilter.getDoctorId()))
        .and(withPatientId(appointmentFilter.getPatientId()))
        .and(withStatus(appointmentFilter.getStatus()));
  }
}
