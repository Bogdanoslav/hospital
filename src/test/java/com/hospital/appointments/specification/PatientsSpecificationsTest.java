package com.hospital.appointments.specification;

import com.hospital.appointments.config.TestConfig;
import com.hospital.appointments.dto.filter.PatientFilter;
import com.hospital.appointments.model.Patient;
import com.hospital.appointments.repo.PatientRepository;
import com.hospital.appointments.services.PatientService;
import com.hospital.appointments.utils.DbTestUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest(classes = {TestConfig.class})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PatientsSpecificationsTest {
  Patient patient1;
  Patient patient2;

  @Autowired private MySQLContainer Container;

  @Autowired private PatientRepository patientRepository;

  @Autowired private PatientService patientService;

  @Autowired private ApplicationContext applicationContext;

  @BeforeEach
  public void createPatients() throws SQLException {
    DbTestUtil.resetAutoIncrementColumns(applicationContext, "patient");
    patient1 = new Patient("Yakov", "Zdzherbinsky", 34, 14);
    patient2 = new Patient("Van", "Koshik", 33, 14);
    patientRepository.save(patient1);
    patientRepository.save(patient2);
  }

  @Test
  @Transactional
  public void givenPatients_WhenFilterNullFindAll_thenReturnAll() {
    PatientFilter patientFilter = new PatientFilter();
    List<Patient> actual = patientService.findAll(patientFilter);
    List<Patient> expected = new ArrayList<>();
    expected.add(patient1);
    expected.add(patient2);
    Assert.assertEquals(expected, actual);
  }

  @Test
  @Transactional
  public void givenPatients_WhenFilterFindAll_thenEquals() {
    PatientFilter patientFilter = new PatientFilter();
    patientFilter.setAge(34);
    patientFilter.setFirstName("ako");
    List<Patient> actual = patientService.findAll(patientFilter);
    List<Patient> expected = new ArrayList<>();
    expected.add(patient1);
    Assert.assertEquals(expected, actual);
  }

  @Test
  @Transactional
  public void givenPatients_WhenWrongFilterFindAll_thenEmpty() {
    PatientFilter patientFilter = new PatientFilter();
    patientFilter.setAge(34);
    patientFilter.setFirstName("ako");
    List<Patient> actual = patientService.findAll(patientFilter);
    List<Patient> expected = new ArrayList<>();
    expected.add(patient1);
    Assert.assertEquals(expected, actual);
  }
}
