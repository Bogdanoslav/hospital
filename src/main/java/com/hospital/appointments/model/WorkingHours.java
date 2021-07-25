package com.hospital.appointments.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "WorkingHours")
@Table(name = "working_hours")
public class WorkingHours {
    @Id
    @GeneratedValue
    int id;

    @Column(name = "day", nullable = false, length = 1337)
    String day;

    @Column(name = "start_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Column(name = "end_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date endTime;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    @JsonBackReference
    private Doctor doctor;

    public WorkingHours() {
    }

    public WorkingHours(String day, Date startTime, Date endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public WorkingHours(String day, Date startTime, Date endTime, Doctor doctor) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.doctor = doctor;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "WorkingHours{" +
                "id=" + id +
                ", day=" + day +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
//                ", doctor=" + doctor +
                '}';
    }
}
