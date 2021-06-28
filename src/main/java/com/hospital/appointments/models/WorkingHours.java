package com.hospital.appointments.models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "WorkingHours")
@Table(name = "working_hours")
public class WorkingHours {
    @Id
    @GeneratedValue
    int id;

    @Column(name = "day", nullable = false)
    int day;

    @Column(name = "start_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "end_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(name = "break_start", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date breakStart;

    @Column(name = "break_end", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date breakEnd;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    public WorkingHours() {
    }

    public WorkingHours(int day, Date startTime, Date endTime, Date breakStart, Date breakEnd) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.breakStart = breakStart;
        this.breakEnd = breakEnd;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
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

    public Date getBreakStart() {
        return breakStart;
    }

    public void setBreakStart(Date breakStart) {
        this.breakStart = breakStart;
    }

    public Date getBreakEnd() {
        return breakEnd;
    }

    public void setBreakEnd(Date breakEnd) {
        this.breakEnd = breakEnd;
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
                ", breakStart=" + breakStart +
                ", breakEnd=" + breakEnd +
                ", doctor=" + doctor +
                '}';
    }
}
