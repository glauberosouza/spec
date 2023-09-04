package com.glauber.spec.data;

import com.glauber.spec.domain.Person;
import com.glauber.spec.web.request.PersonRequest;
import org.springframework.data.jpa.domain.Specification;

public class PersonFilterQuery {
    private final PersonRequest personRequest;

    public PersonFilterQuery(PersonRequest personRequest) {
        this.personRequest = personRequest;
    }

    public Specification<Person> builderFilter() {
        return matchName().and(matchCity());
    }

    private Specification<Person> matchName() {
        return (root, query, criteriaBuilder) -> (personRequest.getName() == null)
                ? null
                : criteriaBuilder.like(
                criteriaBuilder.lower(root.get("name")), "%" + personRequest.getName().toLowerCase() + "%"
        );
    }

    private Specification<Person> matchCity() {
        return (root, query, criteriaBuilder) -> (personRequest.getCity() == null)
                ? null
                : criteriaBuilder.like(
                criteriaBuilder.lower(root.get("city")), "%" + personRequest.getCity().toLowerCase() + "%"
        );
    }
}
