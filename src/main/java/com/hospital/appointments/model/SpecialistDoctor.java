package com.hospital.appointments.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Specialist")
public class SpecialistDoctor extends Doctor {
  @Column(name = "specialty")
  private String specialty;

  public SpecialistDoctor() {}

  public SpecialistDoctor(String firstName, String lastName, String speciality) {
    super(firstName, lastName);
    this.specialty = speciality;
  }

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String speciality) {
    this.specialty = speciality;
  }

  @Override
  public String toString() {
    return "SpecialistDoctor{"
        + "id="
        + id
        + ", firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        +
        //                ", appointments=" + appointments +
        //                ", workingHours=" + workingHours +
        //                ", speciality='" + specialty + '\'' +
        '}';
  }
}
