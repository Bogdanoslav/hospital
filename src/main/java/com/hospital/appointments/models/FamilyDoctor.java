package com.hospital.appointments.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("Family")
public class FamilyDoctor extends Doctor {
    @Column(name = "district")
    private int district;

    @OneToMany(mappedBy = "familyDoctor")
    private Set<Patient> patients;

    public FamilyDoctor() {
    }

    public FamilyDoctor(String firstName, String lastName, int district) {
        super(firstName, lastName);
        this.district = district;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "FamilyDoctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", district=" + district +
                ", patients=" + patients +
                '}';
    }
}
