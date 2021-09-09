package com.hospital.appointments.dto.save;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SaveAppointment {
    Timestamp startTime;
    Timestamp endTime;
    String status;
    BigDecimal price;
    Integer doctorId;
    Integer patientId;
}
