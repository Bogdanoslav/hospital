package com.hospital.appointments.dto.save.doctor;

public class SaveFamilyDoctor{

    protected String firstName;

    protected String lastName;

    private int district;

    public SaveFamilyDoctor() {

    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
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
}
