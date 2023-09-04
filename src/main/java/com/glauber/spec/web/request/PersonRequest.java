package com.glauber.spec.web.request;

import com.glauber.spec.domain.Person;

public class PersonRequest {
    private String name;
    private String city;

    public Person toPerson(){
        var person = new Person();
        person.setName(this.name);
        person.setCity(this.city);
        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}