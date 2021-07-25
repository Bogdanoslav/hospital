package com.hospital.appointments.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("Family")
public class FamilyDoctor extends Doctor {
    @Column(name = "district")
    private int district;

    @OneToMany(mappedBy = "familyDoctor", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<Patient> patients;

    public FamilyDoctor() {
    }

    public FamilyDoctor(String firstName, String lastName, int district) {
        super(firstName, lastName);
        this.district = district;
    }
    public FamilyDoctor(String firstName, String lastName, int district, Set<Patient> patients) {
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
                ", lastName='" + lastName + '\'' +
//                ", appointments=" + appointments +
//                ", workingHours=" + workingHours +
//                ", district=" + district +
                ", patients=" + patients +
                '}';
    }
}
