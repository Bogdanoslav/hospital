package com.hospital.appointments.controllers;

import com.hospital.appointments.config.TestConfig;
import com.hospital.appointments.models.Patient;
import com.hospital.appointments.repo.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:/application.properties")
@SpringBootTest(classes = {TestConfig.class})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PatientsControllerIntTest {

    @Autowired
    public static PostgreSQLContainer Container;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PatientRepository patientRepository;

    @BeforeEach
    public void createPatients() {
        Patient patient1 = new Patient("Yakov", "Zdzherbinsky", 33, 14);
        Patient patient2 = new Patient("Van", "Koshik", 33, 14);
        patientRepository.save(patient1);
        patientRepository.save(patient2);
    }

    @Test
    public void givenPatients_whenGetPatients_thenStatus200() throws Exception {
        mvc.perform(get("/patients/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].firstName", is("Yakov")))
                .andExpect(jsonPath("$[1].firstName", is("Van")));
    }

    @Test
    public void givenPatients_whenGetPatient_thenStatus200() throws Exception {
        mvc.perform(get("/patients/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName", is("Yakov")));
    }

    @Test
    public void create() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/patients/create")
                .param("firstName", "John")
                .param("lastName", "Johnes")
                .param("age", "30")
                .param("district", "14")).
                andExpect(status().isOk());
    }
}