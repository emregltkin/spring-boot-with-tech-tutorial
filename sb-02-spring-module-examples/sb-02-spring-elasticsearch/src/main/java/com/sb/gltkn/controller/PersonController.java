package com.sb.gltkn.controller;

import com.sb.gltkn.entity.Person;
import com.sb.gltkn.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    @PostConstruct
    public void init() {
        Person person = new Person();
        person.setId("ES001");
        person.setName("Emre");
        person.setSurname("Gltkn");
        person.setAddress("İstanbul");
        person.setBirthDate(Calendar.getInstance().getTime());
        personRepository.save(person);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> listPerson(@PathVariable String search) {
        List<Person> personList = personRepository.getPersonListBySearch(search);
        return ResponseEntity.ok(personList);
    }
}
