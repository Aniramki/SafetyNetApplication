package com.Aniramki.SafetyNet.service.DTO;

import java.util.List;

public class PersonInfoDto {
    private String lastName;
    private String adress;
    private int age;
    private List<String> medications;
    private List<String> allergies;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public PersonInfoDto(String lastName, String adress, int age, List<String> medications, List<String> allergies) {
        this.lastName = lastName;
        this.adress = adress;
        this.age = age;
        this.medications = medications;
        this.allergies = allergies;
    }

    public PersonInfoDto() {}
}
