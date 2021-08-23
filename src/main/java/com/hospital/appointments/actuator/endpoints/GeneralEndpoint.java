package com.hospital.appointments.actuator.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "general")
public class GeneralEndpoint {
    private final String NAME = "Appointments Application";
    private final String DESCRIPTION = "My First Spring Boot Application";
    private final String VERSION = "1.0.0";
    private Boolean test = false;

    @Autowired
    MetricsEndpoint metricsEndpoint;

    Map<String, String> output = new ConcurrentHashMap<>();

    @ReadOperation
    public Map<String, String> getDetails() {
        Double runtime = metricsEndpoint.metric("process.uptime", null).getMeasurements().get(0).getValue();
        output.put("name", NAME);
        output.put("description", DESCRIPTION);
        output.put("version", VERSION);
        output.put("runtime", Double.toString(runtime));
        output.put("test", Boolean.toString(test));
        return output;
    }

    @WriteOperation
    public void addDetails(Boolean test) {
        this.test = test;
    }
}
