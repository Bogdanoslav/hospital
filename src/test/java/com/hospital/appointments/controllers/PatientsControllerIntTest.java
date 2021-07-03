package com.hospital.appointments.controllers;

import com.hospital.appointments.initializer.Postgres;
import com.hospital.appointments.models.Patient;
import com.hospital.appointments.repo.PatientRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.*;

import static org.hamcrest.Matchers.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:/test.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {Postgres.Initializer.class})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@Transactional
class PatientsControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PatientRepository patientRepository;

    @BeforeAll
    static void init(){
        Postgres.container.start();
    }

    @BeforeEach
    public void createPatients(){
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
                .param("firstName","John")
                .param("lastName","Johnes")
                .param("age","30")
                .param("district","14")).
                andExpect(status().isOk());
    }
}