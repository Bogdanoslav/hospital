package com.hospital.appointments.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.hospital.appointments")
@PropertySource("application.properties")
public class SpringConfig {
}
