package com.Aniramki.SafetyNet.service.DTO;

import java.util.List;
//import com.fasterxml.jackson.annotation.JsonInclude;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)

public class FireDto {
    private String lastName;
    private String telephone;
    private int age;
    private List<String> medications;
    private List<String> allergies;

    public String getFirestation() {
        return firestation;
    }

    public void setFirestation(String firestation) {
        this.firestation = firestation;
    }

    private String firestation;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public FireDto(String lastName, String telephone, int age, List<String> medications, List<String> allergies, String firestation) {
        this.lastName = lastName;
        this.telephone = telephone;
        this.age = age;
        this.medications = medications;
        this.allergies = allergies;
        this.firestation = firestation;
    }

    public FireDto(String lastName, String telephone, int age, List<String> medications, List<String> allergies) {
        this.lastName = lastName;
        this.telephone = telephone;
        this.age = age;
        this.medications = medications;
        this.allergies = allergies;
    }

    public FireDto() {}
}
