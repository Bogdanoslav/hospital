package com.hospital.appointments.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Referral")
@Table(
        name = "referral",
        uniqueConstraints = {@UniqueConstraint(name = "UC_referral", columnNames = "referral_number")})
public class Referral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id cannot be null")
    private Integer id;

    @Column(name = "referral_number")
    @NotNull(message = "Referral number cannot be null")
    private Integer referralNumber;

    @Column(name = "specialty")
    @NotNull(message = "specialty cannot be null")
    private String specialty;

    @OneToOne(mappedBy = "referral")
    private Appointment appointment;

    @Column (name = "active")
    @NotNull(message = "active cannot be null")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;


    @Override
    public String toString() {
        return "Referral{" +
                "id=" + id +
                ", referralNumber=" + referralNumber +
                ", specialty='" + specialty + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
