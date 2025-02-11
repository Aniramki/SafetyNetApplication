package com.Aniramki.SafetyNet.service.DTO;

import com.Aniramki.SafetyNet.model.Person;

import java.util.List;

public class ChildAlertDto {

    private String firstName;
    private String lastName;
    private int age;
    private List<Person> households;

    public ChildAlertDto(){}


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

    public List<Person> getHouseholds() {
        return households;
    }

    public void setHouseholds(List<Person> households) {
        this.households = households;
    }

    public ChildAlertDto(String firstName, String lastName, int age, List<Person> households) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.households = households;
    }
}
