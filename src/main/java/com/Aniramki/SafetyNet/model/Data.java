package com.Aniramki.SafetyNet.model;

import java.util.List;

public class Data {
    private List <Person> persons;
    private List <FireStation> firestations;
    private List <MedicalRecords> medicalrecords;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<FireStation> getFirestations() {
        return firestations;
    }

    public void setFirestations(List<FireStation> firestations) {
        this.firestations = firestations;
    }

    public List<MedicalRecords> getMedicalrecords() {
        return medicalrecords;
    }

    public void setMedicalrecords(List<MedicalRecords> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }
}
