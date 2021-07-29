package com.hospital.appointments.dto.filter;

public class DoctorFilter {
  private String day;
  private String firstName;
  private String specialty;
  private Integer patientId;

  public DoctorFilter() {}

  public DoctorFilter(String day, String firstName, String specialty, Integer patientId) {
    this.day = day;
    this.firstName = firstName;
    this.specialty = specialty;
    this.patientId = patientId;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }

  public Integer getPatientId() {
    return patientId;
  }

  public void setPatientId(Integer patientId) {
    this.patientId = patientId;
  }
}
