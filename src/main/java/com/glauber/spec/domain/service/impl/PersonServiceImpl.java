package com.glauber.spec.domain.service.impl;

import com.glauber.spec.domain.Person;
import com.glauber.spec.domain.repository.PersonRepository;
import com.glauber.spec.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> search(Specification<Person> personSpecification) {
        return personRepository.findAll(personSpecification);
    }
}
