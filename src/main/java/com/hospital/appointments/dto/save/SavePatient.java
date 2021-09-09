package com.hospital.appointments.dto.save;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SavePatient {
  private int id;

  private String firstName;

  private String lastName;

  private Integer age;

  private Integer district;

  private Integer doctorId;

  public SavePatient(
      int id, String firstName, String lastName, Integer age, Integer district, Integer doctorId) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.district = district;
    this.doctorId = doctorId;
  }
}
