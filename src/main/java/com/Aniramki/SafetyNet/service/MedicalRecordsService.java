package com.Aniramki.SafetyNet.service;


import com.Aniramki.SafetyNet.model.MedicalRecords;
import com.Aniramki.SafetyNet.model.Person;
import com.Aniramki.SafetyNet.repository.FireStationRepository;
import com.Aniramki.SafetyNet.repository.MedicalRecordsRepository;
import com.Aniramki.SafetyNet.repository.PersonRepository;
import com.Aniramki.SafetyNet.service.DTO.PersonInfoDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRecordsService {

    private final PersonRepository personRepository;
    private final MedicalRecordsRepository medicalRecordsRepository;
    private final FireStationRepository fireStationRepository;

    public MedicalRecordsService(PersonRepository personRepository, MedicalRecordsRepository medicalRecordsRepository, FireStationRepository fireStationRepository) {
        this.personRepository = personRepository;
        this.medicalRecordsRepository = medicalRecordsRepository;
        this.fireStationRepository = fireStationRepository;
    }

    public List<PersonInfoDto> findAllPersonWithMedicalRecords(String firstName, String lastName) {
        List<PersonInfoDto> personInfoDto = new ArrayList<>();
        Person person = personRepository.findPersonByFirstNameAndLastName(firstName, lastName);
        MedicalRecords medicalRecords = medicalRecordsRepository.findMedicalRecordsByFirstNameAndLastName(firstName, lastName);
        PersonInfoDto dto = new PersonInfoDto();
        dto.setLastName(person.getLastName());
        dto.setAdress(person.getAddress());
        dto.setMedications(medicalRecords.getMedications());
        dto.setAllergies(medicalRecords.getAllergies());
        dto.setAge(medicalRecordsRepository.findAge(medicalRecords.getBirthdate()));
        personInfoDto.add(dto);
        return personInfoDto;
    }
}
