package com.hospital.appointments.dto.filter;

public class PatientFilter {
  private String firstName;
  private Integer age;

  public PatientFilter() {}

  public PatientFilter(String firstName, Integer age) {
    this.firstName = firstName;
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
