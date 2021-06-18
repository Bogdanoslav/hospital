package org.hospital.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("Family")
public class FamilyDoctor extends Doctor {
    @Column(name = "district", nullable = false)
    private int district;

    @OneToMany(mappedBy = "familyDoctor")
    private Set<Patient> patients;

    public FamilyDoctor() {
    }

    public FamilyDoctor(String firstName, String lastName, int district, Set<Patient> patients) {
        super(firstName, lastName);
        this.district = district;
        this.patients = patients;
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
                ", LastName='" + LastName + '\'' +
                ", district=" + district +
                ", patients=" + patients +
                '}';
    }
}
