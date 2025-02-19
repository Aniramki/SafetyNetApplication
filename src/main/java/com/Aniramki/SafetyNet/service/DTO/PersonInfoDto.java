package com.Aniramki.SafetyNet.service.DTO;

import java.util.List;

public class PersonInfoDto {
    private String lastName;
    private String address;
    private int age;
    private List<String> medications;
    private List<String> allergies;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getMedications() {
        return medications;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public PersonInfoDto(String lastName, String address, int age, List<String> medications, List<String> allergies) {
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.medications = medications;
        this.allergies = allergies;
    }

    public PersonInfoDto() {}
}
