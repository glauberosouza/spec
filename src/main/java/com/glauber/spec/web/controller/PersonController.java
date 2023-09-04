package com.glauber.spec.web.controller;

import com.glauber.spec.data.PersonFilterQuery;
import com.glauber.spec.web.request.PersonRequest;
import com.glauber.spec.domain.Person;
import com.glauber.spec.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody PersonRequest personRequest) {
        personService.save(personRequest.toPerson());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        var response = personService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Person>> search(PersonRequest personRequest) {
        var response = personService.search(new PersonFilterQuery(personRequest).builderFilter());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}