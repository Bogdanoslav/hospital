package com.hospital.appointments.repo;

import com.hospital.appointments.model.Doctor;
import com.hospital.appointments.model.WorkingHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WorkingHoursRepository extends JpaRepository<WorkingHours, Integer>, JpaSpecificationExecutor<WorkingHours> {
}
