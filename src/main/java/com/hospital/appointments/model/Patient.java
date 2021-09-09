package com.hospital.appointments.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Patient")
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id cannot be null")
    private Integer id;

    @Column(name = "first_name")
    @NotNull(message = "First name cannot be null")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @Column(name = "age")
    @PositiveOrZero(message = "Age should be greater or equal 0")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "id_family_doctor")
    private FamilyDoctor familyDoctor;

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointments;

    @Override
    public String toString() {
        return "Patient{"
                + "id="
                + id
                + ", firstName='"
                + firstName
                + '\''
                + ", lastName='"
                + lastName
                + '\''
                + ", age="
                + age
                + ", district=";
    }
}
