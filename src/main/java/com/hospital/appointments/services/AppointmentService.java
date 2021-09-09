package com.hospital.appointments.services;

import com.hospital.appointments.dto.filter.AppointmentFilter;
import com.hospital.appointments.mappers.AppointmentMapper;
import com.hospital.appointments.model.Appointment;
import com.hospital.appointments.repo.AppointmentRepository;
import com.hospital.appointments.specification.appointmentSpecs.AppointmentsSpecBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    AppointmentRepository appointmentRepository;

    AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    public List<Appointment> findAll(AppointmentFilter appointmentFilter) {
        Specification<Appointment> specification = AppointmentsSpecBuilder.buildSpec(appointmentFilter);
        return appointmentRepository.findAll(specification);
    }

    public Appointment findById(Integer id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        return appointment.orElse(null);
    }
}
