package com.hospital.appointments.initializer;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

public class Postgres {
    public static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:12.3");

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url" + container.getJdbcUrl(),
                    "spring.datasource.username" + container.getUsername(),
                    "spring.datasource.password" + container.getPassword()
            ).applyTo(configurableApplicationContext);
        }
    }
}
