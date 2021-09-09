package com.hospital.appointments.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("Specialist")
public class SpecialistDoctor extends Doctor {
    @Column(name = "specialty")
    @NotNull(message = "Speciality cannot be null")
    private String specialty;

    @Override
    public String toString() {
        return "SpecialistDoctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
