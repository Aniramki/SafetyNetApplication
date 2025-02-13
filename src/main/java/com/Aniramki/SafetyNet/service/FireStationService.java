package com.Aniramki.SafetyNet.service;

import com.Aniramki.SafetyNet.model.FireStation;
import com.Aniramki.SafetyNet.model.MedicalRecords;
import com.Aniramki.SafetyNet.model.Person;
import com.Aniramki.SafetyNet.repository.FireStationRepository;
import com.Aniramki.SafetyNet.repository.MedicalRecordsRepository;
import com.Aniramki.SafetyNet.repository.PersonRepository;
import com.Aniramki.SafetyNet.service.DTO.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FireStationService {

    private final PersonRepository personRepository;
    private final MedicalRecordsRepository medicalRecordsRepository;
    private final FireStationRepository fireStationRepository;
    List<String> adress;
    List<String> adress1;

    int childs = 0;
    int adultes =0;
    List<Person> personsByAddress;


    public FireStationService(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordsRepository medicalRecordsRepository) {
        this.personRepository = personRepository;
        this.medicalRecordsRepository = medicalRecordsRepository;
        this.fireStationRepository = fireStationRepository;
    }

    public List<String> findAllAdressByFS(String station) {
         adress = fireStationRepository.findAllFS()
                .stream()
                .filter(f -> f.getStation().equals(station))
                .map(f -> f.getAddress())
                .collect(Collectors.toList());
        return adress;
    }

    public List<String> findAllAdressByFstations(List<String> stations) {
        adress1 = fireStationRepository.findAllFS()
                .stream()
                .filter(f -> stations.contains(f.getStation()))
                .map(f -> f.getAddress())
                .collect(Collectors.toList());
        return adress1;
    }

    public List<String> findAllPhonesPersonByAdress(List<String> adress) {
        List<String> phones = personRepository.findAllPersons()
                .stream()
                .filter(p -> adress.contains(p.getAddress()))
                .map(p -> p.getPhone())
                .collect(Collectors.toList());
        return phones;
    }

public AdultChildDto findNumberChildsAndAdultes () {
     AdultChildDto adultChildDto = new AdultChildDto();
     adultChildDto.setFireStationDtos(findChildsAdultes(adress));
    adultChildDto.setAdult(adultes);
    adultChildDto.setChild(childs);
    return adultChildDto;
}

    public List<FireStationDto> findChildsAdultes(List<String> adress) {
        List<FireStationDto> fireStationDtos = new ArrayList<>();
        ChildAlertDto dto1 = new ChildAlertDto();
        List<Person> persons = personRepository.findAllPersons()
                .stream()
                .filter(p -> adress.contains(p.getAddress()))
                .toList();
        for (Person person : persons) {
            FireStationDto dto3 = new FireStationDto();
            dto3.setLastName(person.getLastName());
            dto3.setFirstName(person.getFirstName());
            dto3.setAddress(person.getAddress());
            dto3.setTelephone(person.getPhone());
            MedicalRecords medicalRecords = medicalRecordsRepository.findMedicalRecordsByFirstNameAndLastName(person.getFirstName(), person.getLastName());
            dto1.setAge(medicalRecordsRepository.findAge(medicalRecords.getBirthdate()));
            if (dto1.getAge()<18)
            {childs +=1;}
                adultes = adultes + 1 - childs;
            fireStationDtos.add(dto3);
        }
        return fireStationDtos;
    }

    public List<FireDto> findAllFloodFiresDtoByAddress(List<Person> personsByAddress) {
        List<FireDto> fireDtos = new ArrayList<>();
        for ( Person person: personsByAddress) {
            FireDto dto3 = new FireDto();
            MedicalRecords medicalRecords = medicalRecordsRepository.findMedicalRecordsByFirstNameAndLastName(person.getFirstName(), person.getLastName());
            dto3.setAge(medicalRecordsRepository.findAge(medicalRecords.getBirthdate()));
            dto3.setMedications(medicalRecords.getMedications());
            dto3.setAllergies(medicalRecords.getAllergies());
            dto3.setTelephone(person.getPhone());
            dto3.setLastName(person.getLastName());
            // dto3.setFirestation(fireStationRepository.findFsByAddress(address).getStation());
            fireDtos.add(dto3);
        }
        return fireDtos;

    }

    public List<FloodDto> findFloodDtos(List<String> fireStations) {
        findAllAdressByFstations(fireStations);
        List<FloodDto> floodDtoList = new ArrayList<>();
        for (int i = 0; i < adress1.size(); i++) {
            personsByAddress = personRepository.findAllPersonByAdress(adress1.get(i))
                    .stream()
                    .toList();
            FloodDto dto4 = new FloodDto();
            dto4.setFireDtoList(findAllFloodFiresDtoByAddress(personsByAddress));
            dto4.setAddress(adress1.get(i));
            floodDtoList.add(dto4);
        }
        return floodDtoList;
    }

}
