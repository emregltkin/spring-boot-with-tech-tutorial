package com.sb.gltkn.controller;

import com.sb.gltkn.dto.PersonDto;
import com.sb.gltkn.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> create(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(personService.save(personDto));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllPerson() {
        return ResponseEntity.ok(personService.getAll());
    }

}
