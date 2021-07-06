package com.hospital.appointments.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.MySQLContainer;

import javax.sql.DataSource;

@TestConfiguration
public class TestConfig {

    // запуск и остановка контейнера по lifecycle-событиями компонента (1)
    @Bean(initMethod = "start", destroyMethod = "stop")
    public JdbcDatabaseContainer<?> jdbcDatabaseContainer() {
        return new MySQLContainer<>("mysql:5.5");// ожидание доступности порта (2)
    }

    @Bean
    public DataSource dataSource(JdbcDatabaseContainer<?> jdbcDatabaseContainer) {
        //DataSourceBuilder dsB = DataSourceBuilder.create();
        //dsB.url(jdbcDatabaseContainer.getJdbcUrl());
        //dsB.username(jdbcDatabaseContainer.getUsername());
        //dsB.password(jdbcDatabaseContainer.getPassword());
        //return dsB.build();
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(jdbcDatabaseContainer.getJdbcUrl());
        hikariConfig.setUsername(jdbcDatabaseContainer.getUsername());
        hikariConfig.setPassword(jdbcDatabaseContainer.getPassword());
        return new HikariDataSource(hikariConfig);
    }
}