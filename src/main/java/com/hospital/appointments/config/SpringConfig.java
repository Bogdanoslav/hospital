package com.hospital.appointments.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Configuration
@ComponentScan("com.hospital.appointments")
public class SpringConfig {
    @Bean
    ModelMapper mapper(){
        return new ModelMapper();
    }
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
        return jacksonObjectMapperBuilder ->
                jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
    }
}
