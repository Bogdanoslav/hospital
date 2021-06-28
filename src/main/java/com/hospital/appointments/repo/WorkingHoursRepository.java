package com.hospital.appointments.repo;

import com.hospital.appointments.models.WorkingHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingHoursRepository extends JpaRepository<WorkingHours, Integer> {
}
