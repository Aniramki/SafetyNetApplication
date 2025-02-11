package com.Aniramki.SafetyNet.service;

import com.Aniramki.SafetyNet.repository.FireStationRepository;
import com.Aniramki.SafetyNet.repository.MedicalRecordsRepository;
import com.Aniramki.SafetyNet.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FireStationService {

    private final PersonRepository personRepository;
    private final MedicalRecordsRepository medicalRecordsRepository;
    private final FireStationRepository fireStationRepository;
    List<String> adress;

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

    public List<String> findAllPhonesPersonByAdress(List<String> adress) {
        List<String> phones = personRepository.findAllPersons()
                .stream()
                .filter(p -> adress.contains(p.getAddress()))
                .map(p -> p.getPhone())
                .collect(Collectors.toList());
        return phones;
    }




}
