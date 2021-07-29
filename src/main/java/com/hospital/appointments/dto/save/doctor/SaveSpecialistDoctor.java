package com.hospital.appointments.dto.save.doctor;

public class SaveSpecialistDoctor {
  protected String firstName;

  protected String lastName;

  private String specialty;

  public SaveSpecialistDoctor() {}

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
