package com.Aniramki.SafetyNet.service;

import com.Aniramki.SafetyNet.model.MedicalRecords;
import com.Aniramki.SafetyNet.model.Person;
import com.Aniramki.SafetyNet.repository.FireStationRepository;
import com.Aniramki.SafetyNet.repository.MedicalRecordsRepository;
import com.Aniramki.SafetyNet.repository.PersonRepository;
import com.Aniramki.SafetyNet.service.DTO.ChildAlertDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final MedicalRecordsRepository medicalRecordsRepository;
    private final FireStationRepository fireStationRepository;

    public PersonService(PersonRepository personRepository, MedicalRecordsRepository medicalRecordsRepository, FireStationRepository fireStationRepository) {
        this.personRepository = personRepository;
        this.medicalRecordsRepository = medicalRecordsRepository;
        this.fireStationRepository = fireStationRepository;
    }

    public List<String> findAllEmailByCity(String city) {
        return personRepository.findAllPersons()
                .stream()
                .filter(p -> p.getCity().equals(city))
                .map(p -> p.getEmail())
                .collect(Collectors.toList());
    }

    public List<ChildAlertDto> findChilds(String address) {
        List<ChildAlertDto> childAlertDtos = new ArrayList<>();
        List<Person> persons = personRepository.findAllPersonByAdress(address);
        List<Person> households = new ArrayList<>();
         for (Person person : persons) {
             ChildAlertDto dto1 = new ChildAlertDto();
             dto1.setLastName(person.getLastName());
             dto1.setFirstName(person.getFirstName());

             MedicalRecords medicalRecords = medicalRecordsRepository.findMedicalRecordsByFirstNameAndLastName(person.getFirstName(), person.getLastName());
        dto1.setAge(medicalRecordsRepository.findAge(medicalRecords.getBirthdate()));
        if (dto1.getAge()<18)childAlertDtos.add(dto1);
        dto1.setHouseholds(persons.stream().filter(p -> !p.getFirstName().equals(dto1.getFirstName())).toList());
         }
        return childAlertDtos;
    }

}
