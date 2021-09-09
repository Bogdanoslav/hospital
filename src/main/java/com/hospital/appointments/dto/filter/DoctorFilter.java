package com.hospital.appointments.dto.filter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoctorFilter {
  private String day;
  private String firstName;
  private String specialty;
  private Integer patientId;
}
