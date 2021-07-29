package com.hospital.appointments.model;

import javax.persistence.*;

@Entity(name = "Referral")
@Table(
    name = "referral",
    uniqueConstraints = {@UniqueConstraint(name = "UC_referral", columnNames = "referral_number")})
public class Referral {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "referral_number", nullable = false)
  private int referralNumber;

  @OneToOne(mappedBy = "referral")
  private Appointment appointment;

  public Referral() {}

  public Referral(int id, int referralNumber) {
    this.id = id;
    this.referralNumber = referralNumber;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getReferralNumber() {
    return referralNumber;
  }

  public void setReferralNumber(int referralNumber) {
    this.referralNumber = referralNumber;
  }

  public Appointment getAppointment() {
    return appointment;
  }

  public void setAppointment(Appointment appointment) {
    this.appointment = appointment;
  }

  @Override
  public String toString() {
    return "Referral{"
        + "id="
        + id
        + ", referralNumber="
        + referralNumber
        +
        //                ", appointment=" + appointment +
        '}';
  }
}
