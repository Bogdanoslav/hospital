package com.hospital.appointments.dto.filter;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentFilter {
  private Timestamp date;
  private String status;
  private Integer doctorId;
  private Integer patientId;

  public void setDate(String date) {
    this.date = new Timestamp(Long.valueOf(date));
  }
}
