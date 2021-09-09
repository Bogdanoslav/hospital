package com.hospital.appointments.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Appointment")
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id cannot be null")
    private Integer id;

    @Column(name = "start_time")
    @Future
    @NotNull(message = "Start time cannot be null")
    private Timestamp startTime;

    @Column(name = "actual_end_time")
    @Future
    @NotNull(message = "End time cannot be null")
    private Timestamp endTime;

    @Column(name = "status")
    @NotNull(message = "Status cannot be null")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    @NotNull(message = "Doctor cannot be null")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    @NotNull(message = "Patient cannot be null")
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "id_referral")
    @NotNull(message = "Referral cannot be null")
    private Referral referral;

    @Override
    public String toString() {
        return "Appointment{"
                + "id="
                + id
                + ", startTime="
                + startTime
                + ", endTime="
                + endTime
                + ", Status='"
                + status
                + '\''
                + ", price=";
    }
}
