package com.hospital.appointments.repo;

import com.hospital.appointments.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AppointmentRepository
    extends JpaRepository<Appointment, Integer>, JpaSpecificationExecutor<Appointment> {}
