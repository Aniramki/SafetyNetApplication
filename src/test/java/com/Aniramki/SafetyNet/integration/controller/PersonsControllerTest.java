package com.Aniramki.SafetyNet.integration.controller;

import com.Aniramki.SafetyNet.controller.PersonsController;
import com.Aniramki.SafetyNet.model.Person;
import com.Aniramki.SafetyNet.service.DTO.ChildAlertDto;
import com.Aniramki.SafetyNet.service.DTO.FireDto;
import com.Aniramki.SafetyNet.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PersonsController.class)
class PersonsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetCommunityEmails() throws Exception {
        List<String> emails = Arrays.asList("test1@example.com", "test2@example.com");

        when(personService.findAllEmailByCity("Paris")).thenReturn(emails);

        mockMvc.perform(get("/communityEmail?city=Paris"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0]").value("test1@example.com"))
                .andExpect(jsonPath("$[1]").value("test2@example.com"));
    }

    @Test
    void testGetChildAlert() throws Exception {
        // Создаём список членов семьи (households)
        List<Person> householdMembers = Arrays.asList(
                new Person(
                        "string",  // firstName
                        "string",  // lastName
                        "string",  // address
                        "string",  // city
                        "string",  // zip
                        "string",  // phone
                        "string"   // email
                )
        );

        // Создаём список детей (ChildAlertDto)
        List<ChildAlertDto> childAlertList = Arrays.asList(
                new ChildAlertDto(
                        "string",      // firstName
                        "string",      // lastName
                        0,             // age
                        householdMembers // Список родственников
                )
        );

        // Мокаем сервисный метод
        when(personService.findChilds("someAddress")).thenReturn(childAlertList);

        // Запускаем тест эндпоинта
        mockMvc.perform(get("/childAlert?address=someAddress"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].firstName").value("string"))
                .andExpect(jsonPath("$[0].lastName").value("string"))
                .andExpect(jsonPath("$[0].age").value(0))
                .andExpect(jsonPath("$[0].households.length()").value(1))
                .andExpect(jsonPath("$[0].households[0].firstName").value("string"))
                .andExpect(jsonPath("$[0].households[0].lastName").value("string"))
                .andExpect(jsonPath("$[0].households[0].address").value("string"))
                .andExpect(jsonPath("$[0].households[0].city").value("string"))
                .andExpect(jsonPath("$[0].households[0].zip").value("string"))
                .andExpect(jsonPath("$[0].households[0].phone").value("string"))
                .andExpect(jsonPath("$[0].households[0].email").value("string"));
    }

    @Test
    void testGetFireInfo() throws Exception {
        List<String> medications = Arrays.asList("hydrapermazol:300mg", "dodoxadin:30mg");
        List<String> allergies = Arrays.asList("shellfish");

        List<FireDto> fireInfo = Arrays.asList(new FireDto(
                "Holik",        // Last Name
                "123-456-789",  // Phone
                17,           // Age
                medications,    // Medications (List<String>)
                allergies,      // Allergies (List<String>)
                "3"             // Firestation Number
        ));

        when(personService.findAllFiresDtoByAddress("123 Street")).thenReturn(fireInfo);

        mockMvc.perform(get("/fire?address=123 Street"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].lastName").value("Holik"))
                .andExpect(jsonPath("$[0].telephone").value("123-456-789"))
                .andExpect(jsonPath("$[0].age").value("17"))
                .andExpect(jsonPath("$[0].medications[0]").value("hydrapermazol:300mg"))
                .andExpect(jsonPath("$[0].medications[1]").value("dodoxadin:30mg"))
                .andExpect(jsonPath("$[0].allergies[0]").value("shellfish"))
                .andExpect(jsonPath("$[0].firestation").value("3"));
    }
    @Test
    void testAddPerson() throws Exception {
        Person person = new Person("Maryna", "Holik", "947 E. Rose Dr", "Culver", "97451", "123-456-7890", "qqqqq@gmail.com");

        when(personService.addNewPerson(any(Person.class))).thenReturn(person);

        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(person)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Maryna"))
                .andExpect(jsonPath("$.lastName").value("Holik"));
    }

    @Test
    void testUpdatePerson() throws Exception {
        Person updatedPerson = new Person("Maryna", "Holik", "New Address", "New City", "00000", "999-999-9999", "new@example.com");

        when(personService.updatePerson(any(Person.class))).thenReturn(updatedPerson);

        mockMvc.perform(put("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedPerson)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.address").value("New Address"))
                .andExpect(jsonPath("$.phone").value("999-999-9999"));
    }

    @Test
    void testDeletePerson() throws Exception {
        Mockito.doNothing().when(personService).deletePerson("Maryna", "Holik");

        mockMvc.perform(delete("/person")
                        .param("firstName", "Maryna")
                        .param("lastName", "Holik"))
                .andExpect(status().isOk());
    }
}
