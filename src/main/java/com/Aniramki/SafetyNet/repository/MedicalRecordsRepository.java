package com.Aniramki.SafetyNet.repository;

import com.Aniramki.SafetyNet.model.MedicalRecords;
import com.Aniramki.SafetyNet.model.Person;
import org.springframework.stereotype.Repository;
import com.Aniramki.SafetyNet.service.DTO.PersonInfoDto;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class MedicalRecordsRepository {
    private final DataHandler dataHandler;

    public MedicalRecordsRepository(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    public List<MedicalRecords> findAllMedicalRecords() {
        return dataHandler.getData().getMedicalrecords();
    }

    public MedicalRecords findMedicalRecordsByFirstNameAndLastName(String firstName, String lastName) {
        return dataHandler.getData().getMedicalrecords().stream()
                .filter(p -> p.getFirstName().equals(firstName))
                .filter(p -> p.getLastName().equals(lastName))
                .findFirst()
                .orElseGet(() -> new MedicalRecords());
    }

    public int findAge(String birthday) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Parse the string to LocalDateTime
        LocalDate birthDate = LocalDate.parse(birthday, formatter);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        return age.getYears();
    }
}
