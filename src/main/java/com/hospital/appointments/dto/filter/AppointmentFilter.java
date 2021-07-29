package com.hospital.appointments.dto.filter;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class AppointmentFilter {
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  Date date;

  String status;
  Integer doctorId;
  Integer patientId;

  public AppointmentFilter() {}

  public AppointmentFilter(Date date, String status, Integer doctorId, Integer patientId) {
    this.date = date;
    this.status = status;
    this.doctorId = doctorId;
    this.patientId = patientId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(Integer doctorId) {
    this.doctorId = doctorId;
  }

  public Integer getPatientId() {
    return patientId;
  }

  public void setPatientId(Integer patientId) {
    this.patientId = patientId;
  }
}
