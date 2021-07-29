package com.hospital.appointments.services;

import com.hospital.appointments.dto.filter.AppointmentFilter;
import com.hospital.appointments.model.Appointment;
import com.hospital.appointments.repo.AppointmentRepository;
import com.hospital.appointments.specification.appointmentSpecs.AppointmentsSpecBuilder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
  @Autowired AppointmentRepository appointmentRepository;

  public List<Appointment> findAll(AppointmentFilter appointmentFilter) {
    Specification<Appointment> specification = AppointmentsSpecBuilder.buildSpec(appointmentFilter);
    return appointmentRepository.findAll(specification);
  }
}
