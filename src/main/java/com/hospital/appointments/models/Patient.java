package com.hospital.appointments.models;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Patient")
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "district", nullable = false)
    private int district;

    @ManyToOne
    @JoinColumn(name = "id_family_doctor")
    private FamilyDoctor familyDoctor;

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointments;

    public Patient() {
    }

    public Patient(String firstName, String lastName, int age, int district) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", district=" + district +
                ", familyDoctor=" + familyDoctor +
                ", appointments=" + appointments +
                '}';
    }
}
