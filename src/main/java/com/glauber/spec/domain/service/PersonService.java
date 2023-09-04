package com.glauber.spec.domain.service;

import com.glauber.spec.domain.Person;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface PersonService {
    void save(Person person);
    List<Person> findAll();
    List<Person> search(Specification<Person> personSpecification);
}
