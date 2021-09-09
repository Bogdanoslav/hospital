package com.hospital.appointments.specification;

import com.hospital.appointments.config.TestConfig;
import com.hospital.appointments.dto.filter.DoctorFilter;
import com.hospital.appointments.model.FamilyDoctor;
import com.hospital.appointments.model.Patient;
import com.hospital.appointments.model.WorkingHours;
import com.hospital.appointments.repo.FamilyDoctorRepository;
import com.hospital.appointments.services.FamilyDoctorService;
import com.hospital.appointments.utils.ColumnIncrementResetter;
import java.sql.SQLException;
import java.sql.Time;
import java.util.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest(classes = {TestConfig.class})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class FamilyDoctorSpecificationsTest {
  FamilyDoctor familyDoctor1;
  FamilyDoctor familyDoctor2;

  @Autowired private ApplicationContext applicationContext;

  @Autowired private MySQLContainer mySQLContainer;

  @Autowired private FamilyDoctorService familyDoctorService;
  @Autowired private FamilyDoctorRepository familyDoctorRepository;

  @BeforeEach
  public void CreateDoctors() throws SQLException {
    ColumnIncrementResetter.resetAutoIncrementColumns(applicationContext, "doctor", "patient");
    familyDoctor1 = new FamilyDoctor("Ivan", "Bikov", 14);
    familyDoctor2 = new FamilyDoctor("Anna", "Turova", 13);
    Set<WorkingHours> workingHours1 = new HashSet<>();
    Set<WorkingHours> workingHours2 = new HashSet<>();
    Set<Patient> patients1 = new HashSet<>();
    Set<Patient> patients2 = new HashSet<>();

    patients1.add(new Patient("Yakov", "Zdzherbinsky", 34, 14, familyDoctor1));
    workingHours1.add(new WorkingHours("SAT", new Time(9), new Time(20), familyDoctor1));
    familyDoctor1.setWorkingHours(workingHours1);
    familyDoctor1.setPatients(patients1);

    patients2.add(new Patient("Van", "Koshik", 33, 14, familyDoctor2));
    workingHours2.add(new WorkingHours("SUN", new Time(9), new Time(20), familyDoctor2));
    familyDoctor2.setWorkingHours(workingHours2);
    familyDoctor2.setPatients(patients2);

    familyDoctorRepository.save(familyDoctor1);
    familyDoctorRepository.save(familyDoctor2);
  }

  @Test
  @Transactional
  public void givenFamilyDoctors_WhenFilterNullFindAll_thenReturnAll() {
    List<FamilyDoctor> actual = familyDoctorService.findAll(new DoctorFilter());
    List<FamilyDoctor> expected = new ArrayList<>();
    expected.add(familyDoctor1);
    expected.add(familyDoctor2);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  @Transactional
  public void givenFamilyDoctors_WhenFilterFindAll_thenEquals() {
    DoctorFilter doctorFilter = new DoctorFilter();
    doctorFilter.setDay("SUN");
    doctorFilter.setPatientId(2);
    doctorFilter.setFirstName("Anna");
    List<FamilyDoctor> actual = familyDoctorService.findAll(doctorFilter);
    List<FamilyDoctor> expected = new ArrayList<>();
    expected.add(familyDoctor2);
    System.out.println(expected);
    System.out.println(actual);
    System.out.println();
    Assertions.assertEquals(expected, actual);
  }

  @Test
  @Transactional
  public void givenFamilyDoctors_WhenWrongFilterFindAll_thenEmpty() {
    DoctorFilter doctorFilter = new DoctorFilter();
    doctorFilter.setDay("SAT");
    doctorFilter.setPatientId(3);
    List<FamilyDoctor> actual = familyDoctorService.findAll(doctorFilter);
    Assertions.assertEquals(actual.size(), 0);
  }
}
