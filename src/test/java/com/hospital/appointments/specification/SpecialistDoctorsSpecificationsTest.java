package com.hospital.appointments.specification;

import com.hospital.appointments.config.TestConfig;
import com.hospital.appointments.dto.filter.DoctorFilter;
import com.hospital.appointments.model.SpecialistDoctor;
import com.hospital.appointments.model.WorkingHours;
import com.hospital.appointments.services.SpecialistDoctorService;
import com.hospital.appointments.utils.DbTestUtil;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MySQLContainer;

import java.sql.SQLException;
import java.sql.Time;
import java.util.*;

@SpringBootTest(classes = {TestConfig.class})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class SpecialistDoctorsSpecificationsTest {

    SpecialistDoctor specialistDoctor1;
    SpecialistDoctor specialistDoctor2;

    @Autowired
    private MySQLContainer mySQLContainer;

    @Autowired
    private SpecialistDoctorService specialistDoctorService;

    @Autowired
    private ApplicationContext applicationContext;

    @BeforeEach
    public void CreateDoctors() throws SQLException {
        DbTestUtil.resetAutoIncrementColumns(applicationContext, "doctor", "working_hours");
        specialistDoctor1 = new SpecialistDoctor("Ivan", "Bikov", "surgeon");
        specialistDoctor2 = new SpecialistDoctor("Anna", "Turova", "cardiologist");
        Set<WorkingHours> workingHours1 = new HashSet<>();
        Set<WorkingHours> workingHours2 = new HashSet<>();

        workingHours1.add(new WorkingHours("SAT", new Time(9), new Time(20), specialistDoctor1));
        specialistDoctor1.setWorkingHours(workingHours1);

        workingHours2.add(new WorkingHours("SUN", new Time(9), new Time(20), specialistDoctor2));
        specialistDoctor2.setWorkingHours(workingHours2);

        specialistDoctorService.save(specialistDoctor1);
        specialistDoctorService.save(specialistDoctor2);
    }

    @Test
    @Transactional
    public void givenSpecialists_WhenFilterNullFindAll_thenReturnAll() {
        DoctorFilter doctorFilter = new DoctorFilter();
        List<SpecialistDoctor> actual = specialistDoctorService.findAll(doctorFilter);
        List<SpecialistDoctor> expected = new ArrayList<>();
        expected.add(specialistDoctor1);
        expected.add(specialistDoctor2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Transactional
    public void givenSpecialists_WhenFilterFindAll_thenEquals() {
        DoctorFilter doctorFilter = new DoctorFilter();
        doctorFilter.setFirstName("van");
        doctorFilter.setSpecialty("surgeon");
        doctorFilter.setDay("SAT");
        List<SpecialistDoctor> actual = specialistDoctorService.findAll(doctorFilter);
        List<SpecialistDoctor> expected = new ArrayList<>();
        expected.add(specialistDoctor1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Transactional
    public void givenSpecialists_WhenFilterWrongFilter_thenEmpty() {
        DoctorFilter doctorFilter = new DoctorFilter();
        doctorFilter.setFirstName("van");
        doctorFilter.setSpecialty("surgeon");
        doctorFilter.setDay("XXX");
        List<SpecialistDoctor> actual = specialistDoctorService.findAll(doctorFilter);
        Assertions.assertEquals(actual.size(),0);
    }

}
