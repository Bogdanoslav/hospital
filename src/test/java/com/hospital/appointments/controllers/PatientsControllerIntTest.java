package com.hospital.appointments.controllers;

import com.hospital.appointments.models.Patient;
import com.hospital.appointments.repo.PatientRepository;
import javafx.application.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(
        //webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        //classes = Application.class
        )
@AutoConfigureMockMvc
@TestPropertySource(locations = "application-integrationtest.properties")
class PatientsControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    PatientsController patientsController;

    @Autowired
    PatientRepository patientRepository;

    @Test
    void index() {
        Patient patient = new Patient("Yakov", "Zdzherbinsky", 33, 14);
        patientRepository.save(patient);
        Assertions.assertEquals(patientRepository.findById(1).get(),patient);
    }

    @Test
    void show() {

    }

    @Test
    void create() {

    }
}