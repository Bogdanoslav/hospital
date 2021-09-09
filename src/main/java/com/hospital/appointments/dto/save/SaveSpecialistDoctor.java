package com.hospital.appointments.dto.save;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveSpecialistDoctor {
  protected String firstName;
  protected String lastName;
  private String specialty;
}
