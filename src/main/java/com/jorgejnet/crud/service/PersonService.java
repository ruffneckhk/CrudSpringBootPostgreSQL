package com.jorgejnet.crud.service;

import com.jorgejnet.crud.model.Person;
import com.jorgejnet.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }
}
