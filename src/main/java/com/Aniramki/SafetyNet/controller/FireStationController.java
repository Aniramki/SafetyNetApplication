package com.Aniramki.SafetyNet.controller;

import com.Aniramki.SafetyNet.service.DTO.AdultChildDto;
import com.Aniramki.SafetyNet.service.DTO.FloodDto;
import com.Aniramki.SafetyNet.service.FireStationService;
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

    @RequestMapping(value = "firestation", method = RequestMethod.GET)
    public AdultChildDto ListePersonsAdultsEnfants(@RequestParam(name = "stationNumber") String stationNumber) {
        List<String> adress = this.fireStationService.findAllAdressByFS(stationNumber);
        return fireStationService.findNumberChildsAndAdultes();

    }

    @RequestMapping(value = "/flood/stations", method = RequestMethod.GET)
    public List<FloodDto> floodDtoList(@RequestParam List<String> stations) {
        return this.fireStationService.findFloodDtos(stations);
    }


}
