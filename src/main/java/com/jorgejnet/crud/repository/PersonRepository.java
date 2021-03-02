package com.jorgejnet.crud.repository;

import com.jorgejnet.crud.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
