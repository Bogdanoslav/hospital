package com.hospital.appointments.controllers;

import com.hospital.appointments.dto.filter.AppointmentFilter;
import com.hospital.appointments.model.Appointment;
import com.hospital.appointments.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentsController {
    AppointmentService appointmentService;

    @Autowired
    public AppointmentsController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/all")
    public List<Appointment> findAllAppointments(@ModelAttribute AppointmentFilter appointmentFilter) {
        return appointmentService.findAll(appointmentFilter);
    }
    @GetMapping("/{id}")
    public Appointment findAppointmentById(@PathVariable Integer id) {
        return appointmentService.findById(id);
    }
}
