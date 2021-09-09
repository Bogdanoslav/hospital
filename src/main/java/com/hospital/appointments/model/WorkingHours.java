package com.hospital.appointments.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "WorkingHours")
@Table(name = "working_hours")
public class WorkingHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id cannot be null")
    private Integer id;

    @Column(name = "day")
    @NotNull(message = "Day cannot Be null") @Min(value = 1, message = "Day should be greater than 0") @Max(value = 7, message = "Day should be less or equal 7")
    private String day;

    @Column(name = "start_time")
    @Future @NotNull(message = "Start time cannot be null")
    private Timestamp startTime;

    @Column(name = "end_time")
    @Future @NotNull(message = "End time cannot be null")
    private Timestamp endTime;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    @Override
    public String toString() {
        return "WorkingHours{"
                + "id="
                + id
                + ", day="
                + day
                + ", startTime="
                + startTime
                + ", endTime="
                + endTime
                + '}';
    }
}
