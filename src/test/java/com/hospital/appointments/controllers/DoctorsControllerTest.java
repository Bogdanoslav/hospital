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
@SpringBootTest(classes = TestConfig.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@Sql(
    value = {"/testSqlQueries/insertFamilyDoctors.sql", "/testSqlQueries/insertPatients.sql"},
    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class DoctorsControllerTest {

  @Autowired private MySQLContainer mySQLContainer;

  @Autowired private MockMvc mockMvc;

  @Test
  @Transactional
  public void givenFamilyDoctors_WhenGetFamilyDoctorsAll_ThenStatus200() throws Exception {
    mockMvc
        .perform(get("/doctors/family/all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[0].firstName", is("Dmitry")))
        .andExpect(jsonPath("$[1].firstName", is("Anna")));
  }

  @Test
  @Transactional
  public void givenFamilyDoctors_WhenGetFamilyDoctorsById_ThenStatus200() throws Exception {
    mockMvc
        .perform(get("/doctors/family/4").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.firstName", is("Dmitry")));
  }

  @Test
  @Transactional
  public void WhenWrongUrl_Return404() throws Exception {
    mockMvc
        .perform(get("/doctors/fmily/4").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError());
  }

  @Transactional
  @Test
  public void create() throws Exception {
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/doctors/family/create")
                .param("firstName", "John")
                .param("lastName", "Johnes")
                .param("district", "14"))
        .andExpect(status().isOk());
  }
}
