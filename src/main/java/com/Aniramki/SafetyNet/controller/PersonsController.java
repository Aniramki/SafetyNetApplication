package com.Aniramki.SafetyNet.controller;

import com.Aniramki.SafetyNet.service.DTO.ChildAlertDto;
import com.Aniramki.SafetyNet.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonsController {

    private final PersonService personService;

    PersonsController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "communityEmail", method = RequestMethod.GET)
    public List<String> ListeEmails(@RequestParam(name = "city") String city) {
        return this.personService.findAllEmailByCity(city);
    }

    @RequestMapping(value = "childAlert", method = RequestMethod.GET)
    public List<ChildAlertDto> ListePersons(@RequestParam(name = "address") String address) {
        return this.personService.findChilds(address);
    }
}
