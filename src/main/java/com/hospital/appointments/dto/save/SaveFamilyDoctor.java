package com.hospital.appointments.dto.save;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveFamilyDoctor {
  protected String firstName;
  protected String lastName;
  private int district;
}
