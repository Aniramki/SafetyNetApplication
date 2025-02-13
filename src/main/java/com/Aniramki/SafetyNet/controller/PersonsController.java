package com.Aniramki.SafetyNet.controller;

import com.Aniramki.SafetyNet.model.Person;
//import com.Aniramki.SafetyNet.model.FireStation;

import com.Aniramki.SafetyNet.service.DTO.AdultChildDto;
import com.Aniramki.SafetyNet.service.DTO.ChildAlertDto;
import com.Aniramki.SafetyNet.service.DTO.FireDto;
import com.Aniramki.SafetyNet.service.DTO.FloodDto;
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



//    @PostMapping("/person")
//    public List <Person> addNewPerson(@RequestBody Person person)
////            (
////            @RequestParam(name = "firstName") String firstName,
////            @RequestParam(name = "lastName") String lastName,
////            @RequestParam(name = "address") String address,
////            @RequestParam(name = "city") String city,
////            @RequestParam(name = "zip") String zip,
////            @RequestParam(name = "phone") String phone,
////            @RequestParam(name = "email") String email)
//    {
//{
//    "firstName": "Maryna",
//        "lastName": "Holik",
//        "address": "947 E. Rose Dr",
//        "city": "Culver",
//        "zip": "97451",
//        "phone": "123-456-7890",
//        "email": "qqqqq@gmail.com"
//}
//
//        return this.personService.addNewPerson(person);
//    }
//
//    @PostMapping("/add")
//    public Teacher addTeacher(@RequestBody Teacher teacher) {
//        return teacherService.createTeacher(teacher);
//    }

}
