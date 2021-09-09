package com.hospital.appointments.mappers;

import com.hospital.appointments.dto.save.SaveAppointment;
import com.hospital.appointments.model.Appointment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    private ModelMapper mapper;

    @Autowired
    public AppointmentMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Appointment dtoToEntity(SaveAppointment saveAppointment) {
        return mapper.map(saveAppointment, Appointment.class);
    }
}
