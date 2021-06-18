package org.hospital.models;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Doctor")
@Table(name = "doctor")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "doctor_type")
public abstract class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    @Column(name = "first_name", nullable = false)
    protected String firstName;

    @Column(name = "last_name", nullable = false)
    protected String LastName;

    @OneToMany(mappedBy = "doctor")
    Set<Appointment> appointments;

    @OneToMany(mappedBy = "doctor")
    Set<WorkingHours> workingHours;

    public Doctor() {
    }

    public Doctor(String firstName, String lastName) {
        this.firstName = firstName;
        LastName = lastName;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Set<WorkingHours> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Set<WorkingHours> workingHours) {
        this.workingHours = workingHours;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
}
