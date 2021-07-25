package com.hospital.appointments.controllers;

import com.hospital.appointments.model.Appointment;
import com.hospital.appointments.repo.AppointmentRepository;
import com.hospital.appointments.services.AppointmentService;
import com.hospital.appointments.dto.filter.AppointmentFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentsController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/all")
    public List<Appointment> getAllAppointments(@ModelAttribute AppointmentFilter appointmentFilter) {
        return appointmentService.findAll(appointmentFilter);
    }

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        //The date format to parse or output your dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        //dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Kiev"));
        //Create a new CustomDateEditor
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        //Register it as custom editor for the Date type
        binder.registerCustomEditor(Date.class, editor);
    }
}
