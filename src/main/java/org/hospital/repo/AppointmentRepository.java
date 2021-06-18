package org.hospital.repo;

import org.hospital.models.Appointment;
import org.hospital.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
