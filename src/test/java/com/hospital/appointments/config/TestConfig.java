package com.hospital.appointments.config;

import com.zaxxer.hikari.util.DriverDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//@Profile("postgres")
public class TestConfig {

    @Bean
    @Primary
    public PostgreSQLContainer embeddedPostgres() {
        PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11.1")
                .withDatabaseName("go_goals")
                .withUsername("postgres")
                .withPassword("postgres");

        postgreSQLContainer.start();
        return postgreSQLContainer;
    }
    @DependsOn("embeddedPostgres")
    @Bean
    @Primary
    public DataSource dataSource(PostgreSQLContainer postgreSQLContainer) {
        String jdbcUrl = postgreSQLContainer.getJdbcUrl();
        String username = postgreSQLContainer.getUsername();
        String password = postgreSQLContainer.getPassword();

        return new DriverDataSource(jdbcUrl, "org.postgresql.Driver", new Properties(), username, password);
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
    /*@Bean
    public DataSource dataSource(JdbcDatabaseContainer<?> jdbcDatabaseContainer) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(jdbcDatabaseContainer.getJdbcUrl());
        hikariConfig.setUsername(jdbcDatabaseContainer.getUsername());
        hikariConfig.setPassword(jdbcDatabaseContainer.getPassword());
        return new HikariDataSource(hikariConfig);
    }*/
}