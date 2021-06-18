package org.hospital.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@DiscriminatorValue("Specialist")
public class SpecialistDoctor extends Doctor{
    @Column(name = "specialty")
    private String speciality;

    public SpecialistDoctor() {
    }

    public SpecialistDoctor(String firstName, String lastName, String speciality) {
        super(firstName, lastName);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "SpecialistDoctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", appointments=" + appointments +
                ", workingHours=" + workingHours +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
