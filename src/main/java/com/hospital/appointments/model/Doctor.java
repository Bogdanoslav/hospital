package com.hospital.appointments.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Doctor")
@Table(name = "doctor")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "doctor_type")
public abstract class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id cannot be null")
    protected Integer id;

    @Column(name = "first_name")
    @NotNull(message = "First name cannot be null")
    protected String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Last name cannot be null")
    protected String lastName;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.PERSIST)
    protected Set<Appointment> appointments;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.PERSIST)
    protected Set<WorkingHours> workingHours;


    @Override
    public String toString() {
        return "Doctor{"
                + "id="
                + id
                + ", firstName='"
                + firstName
                + '\''
                + ", lastName='"
                + lastName
                + '\''
                +
                '}';
    }
}
