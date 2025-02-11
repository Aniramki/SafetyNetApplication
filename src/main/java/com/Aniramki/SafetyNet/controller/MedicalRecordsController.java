package com.Aniramki.SafetyNet.controller;


import com.Aniramki.SafetyNet.service.DTO.PersonInfoDto;
import com.Aniramki.SafetyNet.service.MedicalRecordsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicalRecordsController {

    private final MedicalRecordsService medicalRecordsService;

   public MedicalRecordsController(MedicalRecordsService medicalRecordsService) {
        this.medicalRecordsService = medicalRecordsService;
    }

    @RequestMapping(value = "personInfo", method = RequestMethod.GET)
    public List<PersonInfoDto> personInfoDtos(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
        List<PersonInfoDto> personInfoDtos = this.medicalRecordsService.findAllPersonWithMedicalRecords(firstName, lastName);
        return personInfoDtos;

    }
}
