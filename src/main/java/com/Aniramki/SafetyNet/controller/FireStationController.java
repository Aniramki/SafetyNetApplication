package com.Aniramki.SafetyNet.controller;

import com.Aniramki.SafetyNet.model.Person;
import com.Aniramki.SafetyNet.service.FireStationService;
import com.Aniramki.SafetyNet.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FireStationController {

    private final FireStationService fireStationService;

    FireStationController(FireStationService fireStationService) {
        this.fireStationService = fireStationService;
    }

    @RequestMapping(value = "phoneAlert", method = RequestMethod.GET)
    public List<String> ListePhone(@RequestParam(name = "stationNumber") String stationNumber) {
        List<String> adress = this.fireStationService.findAllAdressByFS(stationNumber);
        List<String> phones = this.fireStationService.findAllPhonesPersonByAdress(adress);
         return phones;

    }

//    @RequestMapping(value = "firestation", method = RequestMethod.GET)
//    public List<String> ListePersonsAdultsEnfants(@RequestParam(name = "stationNumber") String stationNumber) {
//        List<String> adress = this.fireStationService.findAllAdressByFS(stationNumber);
//        List<String> personList = this.fireStationService.findAllPersonByAdress(adress);
//        return personList;
//
//    }
}
