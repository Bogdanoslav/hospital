package com.hospital.appointments.controllers;

import com.hospital.appointments.dto.filter.AppointmentFilter;
import com.hospital.appointments.model.Appointment;
import com.hospital.appointments.services.AppointmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentsController {
  @Autowired AppointmentService appointmentService;

  @GetMapping("/all")
  public List<Appointment> getAllAppointments(@ModelAttribute AppointmentFilter appointmentFilter) {
    return appointmentService.findAll(appointmentFilter);
  }

  //    @InitBinder
  //    private void dateBinder(WebDataBinder binder) {
  //        //The date format to parse or output your dates
  //        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
  //        //dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Kiev"));
  //        //Create a new CustomDateEditor
  //        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
  //        //Register it as custom editor for the Date type
  //        binder.registerCustomEditor(Date.class, editor);
  //    }
}
