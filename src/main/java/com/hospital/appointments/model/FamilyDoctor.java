package com.hospital.appointments.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("Family")
public class FamilyDoctor extends Doctor {

    @OneToMany(mappedBy = "familyDoctor", cascade = CascadeType.PERSIST)
    private Set<Patient> patients;

    @Override
    public String toString() {
        return "FamilyDoctor{"
                + "id="
                + id
                + ", firstName='"
                + firstName
                + '\''
                + ", lastName='"
                + lastName
                + '\''
                + ", patients="
                + patients
                + '}';
    }
}
