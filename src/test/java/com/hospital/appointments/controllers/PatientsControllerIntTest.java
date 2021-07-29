package com.hospital.appointments.controllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.hospital.appointments.config.TestConfig;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MySQLContainer;

@AutoConfigureMockMvc
@SpringBootTest(classes = {TestConfig.class})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@Sql(
    value = "/testSqlQueries/insertPatients.sql",
    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class PatientsControllerIntTest {

  @Autowired private MySQLContainer Container;

  @Autowired private MockMvc mvc;

  @Test
  @Transactional
  public void givenPatients_whenGetPatients_thenStatus200() throws Exception {
    mvc.perform(get("/patients/all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[0].firstName", is("Arseniy")))
        .andExpect(jsonPath("$[1].firstName", is("Bob")));
  }

  @Test
  @Transactional
  public void givenPatients_whenGetPatient_thenStatus200() throws Exception {
    mvc.perform(get("/patients/1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.firstName", is("Arseniy")));
  }

  @Test
  @Transactional
  public void WhenWrongUrl_Return404() throws Exception {
    mvc.perform(get("/doctors/fmily/4").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError());
  }

  @Transactional
  @Test
  public void create() throws Exception {
    mvc.perform(
            MockMvcRequestBuilders.post("/patients/create")
                .param("firstName", "John")
                .param("lastName", "Johnes")
                .param("age", "30")
                .param("district", "14"))
        .andExpect(status().isOk());
  }
}
