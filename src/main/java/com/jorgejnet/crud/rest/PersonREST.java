package com.jorgejnet.crud.rest;


import com.jorgejnet.crud.model.Person;
import com.jorgejnet.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person/")
public class PersonREST {
    @Autowired
    private PersonService personService;

    @PostMapping
    private ResponseEntity<Person> save(@RequestBody Person person) {
        Person temp = personService.createPerson(person);

        try {
            return ResponseEntity.created(new URI("/api/persona" + temp.getId())).body(temp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Person>> listAllPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @DeleteMapping
    private ResponseEntity<Void> deletePerson(@RequestBody Person person) {
        personService.deletePerson(person);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}")
    private ResponseEntity<Optional<Person>> listPersonsById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }
}
