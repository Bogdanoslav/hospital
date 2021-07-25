package com.hospital.appointments.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Appointment")
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    @Column(name = "start_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "actual_end_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;



    @Column(name = "status", nullable = false)
    private String Status;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    @JsonBackReference
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "id_referral")
    @JsonBackReference
    private Referral referral;

    public Appointment() {
    }

    public Appointment(Date startTime, Date endTime, String status, Double price) {
        this.startTime = startTime;
        this.endTime = endTime;
        Status = status;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Referral getReferral() {
        return referral;
    }

    public void setReferral(Referral referral) {
        this.referral = referral;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", date=" + date +
                ", Status='" + Status + '\'' +
                ", price=" + price +
//                ", doctor=" + doctor +
//                ", patient=" + patient +
//                ", referral=" + referral +
                '}';
    }
}
