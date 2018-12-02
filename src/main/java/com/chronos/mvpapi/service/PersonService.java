package com.chronos.mvpapi.service;

import com.chronos.mvpapi.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    public Person salve(Person person) {


        return person;
    }

    public Person update(String uuid, Person person) {

        return person;
    }
}
