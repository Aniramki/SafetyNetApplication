package com.Aniramki.SafetyNet.controller;

import com.Aniramki.SafetyNet.model.Person;
import com.Aniramki.SafetyNet.service.DTO.ChildAlertDto;
import com.Aniramki.SafetyNet.service.DTO.FireDto;
import com.Aniramki.SafetyNet.service.PersonService;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "fire", method = RequestMethod.GET)
    public List<FireDto> ListeFireDto(@RequestParam(name = "address") String address) {
        return this.personService.findAllFiresDtoByAddress(address);
    }

//Endpoints /person

    @PostMapping("/person")
    public Person addNewPerson(@RequestBody Person person)

//            (@RequestParam(name = "firstName") String firstName,
//            @RequestParam(name = "lastName") String lastName,
//            @RequestParam(name = "address") String address,
//            @RequestParam(name = "city") String city,
//            @RequestParam(name = "zip") String zip,
//            @RequestParam(name = "phone") String phone,
//            @RequestParam(name = "email") String email)
    {
        return personService.addNewPerson(person);
    }

    @PutMapping("/person")
    public Person updatePerson(@RequestBody Person person)
    {
        System.out.println("Received person: " + person.getFirstName() + " " + person.getLastName());
        return personService.updatePerson(person);
    }

    @DeleteMapping("/person")
    public void deletePerson(@RequestParam(name = "firstName") String firstName,
         @RequestParam(name = "lastName") String lastName)
    {
       //Person person = pe
        personService.deletePerson(firstName, lastName);
        System.out.println("person delete: ");
       // System.out.println(personList.toString()+personList.size());

    }



}
