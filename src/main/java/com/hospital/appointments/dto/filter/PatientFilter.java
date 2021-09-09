package com.hospital.appointments.dto.filter;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatientFilter {
  private String firstName;
  private Integer age;
}
