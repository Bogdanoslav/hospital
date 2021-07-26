package com.hospital.appointments.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.util.DriverDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.MySQLContainer;

import javax.servlet.ServletContext;
import javax.sql.DataSource;
import java.util.Properties;

@TestConfiguration
@PropertySource("application.properties")
@EnableJpaRepositories("com.hospital.appointments.repo")
@ComponentScan("com.hospital.appointments")
@Import(SpringConfig.class)
@EnableAutoConfiguration
public class TestConfig {

    @Bean
    @Primary
    public MySQLContainer embeddedMySql() {
        MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.0.12")
                .withDatabaseName("hospital")
                .withUsername("root")
                .withPassword("root");
        mySQLContainer.start();
        return mySQLContainer;
    }
    @DependsOn("embeddedMySql")
    @Bean
    @Primary
    public DataSource dataSource(MySQLContainer mySQLContainer) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(mySQLContainer.getJdbcUrl());
        hikariConfig.setUsername(mySQLContainer.getUsername());
        hikariConfig.setPassword(mySQLContainer.getPassword());

        return new HikariDataSource(hikariConfig);
    }
    @Bean
    @Primary
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDropFirst(true);
        liquibase.setDataSource(dataSource);
        liquibase.setIgnoreClasspathPrefix(false);
        liquibase.setChangeLog("classpath:/db/changelog/changelog-master.xml");
        return liquibase;
    }
}